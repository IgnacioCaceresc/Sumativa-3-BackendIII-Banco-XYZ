package com.banco.xyz.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaAuditoriaListener {

    @KafkaListener(topics = "atm-auditoria", groupId = "banco-xyz-group")
    public void listen(String message) {
        System.out.println("========== EVENTO KAFKA RECIBIDO ==========");
        System.out.println("Mensaje: " + message);
        System.out.println("===========================================");
    }
}
