package com.banco.xyz.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.banco.xyz.dto.AtmSaldoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/atm")
public class AtmBffController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/saldo/{cuenta}")
    @CircuitBreaker(name = "coreService", fallbackMethod = "saldoFallback")
    public ResponseEntity<?> getSaldoAtm(@PathVariable String cuenta) {
        // Simulador de caida del servicio Core para probar Resilience4j
        if ("CTA-ERROR".equals(cuenta)) {
            throw new RuntimeException("Simulacion de fallo de conexion con el Core bancario");
        }

        // Enviar evento asÃ­ncrono a Kafka cada vez que se consulta en el ATM
        jmsTemplate.convertAndSend("atm-auditoria", "Consulta de saldo realizada en ATM para la cuenta: " + cuenta);

        // LÃ³gica normal
        AtmSaldoDto response = new AtmSaldoDto(cuenta, 50000.00);
        return ResponseEntity.ok(response);
    }

    // MÃ©todo de Tolerancia a Fallos (Resilience4j)
    public ResponseEntity<?> saldoFallback(String cuenta, Throwable t) {
        // En caso de fallo (circuito abierto), devolvemos el mensaje solicitado
        return ResponseEntity.status(503).body("No se puede realizar la accion, por favor intente mas tarde");
    }
}

