package com.banco.xyz.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaAuditoriaListener {

    @JmsListener(destination = "atm-auditoria")
    public void listen(String message) {
        System.out.println("========== EVENTO KAFKA RECIBIDO ==========");
        System.out.println("Mensaje: " + message);
        System.out.println("===========================================");
    }
}

