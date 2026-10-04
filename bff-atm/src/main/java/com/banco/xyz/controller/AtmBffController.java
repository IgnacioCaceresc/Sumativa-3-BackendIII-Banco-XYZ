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
    public ResponseEntity<AtmSaldoDto> getSaldoAtm(@PathVariable String cuenta) {
        // Enviar evento asÃ­ncrono a Kafka cada vez que se consulta en el ATM
        jmsTemplate.convertAndSend("atm-auditoria", "Consulta de saldo realizada en ATM para la cuenta: " + cuenta);

        // LÃ³gica normal
        AtmSaldoDto response = new AtmSaldoDto(cuenta, 50000.00);
        return ResponseEntity.ok(response);
    }

    // MÃ©todo de Tolerancia a Fallos (Resilience4j)
    public ResponseEntity<AtmSaldoDto> saldoFallback(String cuenta, Throwable t) {
        // En caso de fallo (circuito abierto), devolvemos saldo -1.0 para indicar indisponibilidad
        AtmSaldoDto fallbackResponse = new AtmSaldoDto(cuenta, -1.0);
        return ResponseEntity.status(503).body(fallbackResponse);
    }
}

