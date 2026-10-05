package com.banco.xyz.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaAuditoriaListener {

    @JmsListener(destination = "atm-auditoria")
    public void listen(String message) {
        System.out.println("\n=======================================================");
        System.out.println(" \uD83DFE2 EVENTO JMS RECIBIDO DE FORMA ASINCRONA");
        System.out.println(" \uD83DDDD DETALLE: " + message);
        System.out.println("=======================================================\n");
    }
}

