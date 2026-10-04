package com.banco.xyz.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.banco.xyz.dto.AtmSaldoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/atm")
public class AtmBffController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/saldo/{cuenta}")
    @CircuitBreaker(name = "coreService", fallbackMethod = "saldoFallback")
    public ResponseEntity<AtmSaldoDto> getSaldoAtm(@PathVariable String cuenta) {
        // Enviar evento asíncrono a Kafka cada vez que se consulta en el ATM
        kafkaTemplate.send("atm-auditoria", "Consulta de saldo realizada en ATM para la cuenta: " + cuenta);

        // Lógica normal
        AtmSaldoDto response = new AtmSaldoDto();
        response.setNumeroCuenta(cuenta);
        response.setSaldoDisponible(new BigDecimal("50000.00"));
        response.setMoneda("CLP");
        response.setMensajePantalla("Opere con precaución.");
        return ResponseEntity.ok(response);
    }

    // Método de Tolerancia a Fallos (Resilience4j)
    public ResponseEntity<AtmSaldoDto> saldoFallback(String cuenta, Throwable t) {
        AtmSaldoDto fallbackResponse = new AtmSaldoDto();
        fallbackResponse.setNumeroCuenta(cuenta);
        fallbackResponse.setMensajePantalla("Servicio temporalmente no disponible (Circuit Breaker Activo). Intente más tarde.");
        return ResponseEntity.status(503).body(fallbackResponse);
    }
}
