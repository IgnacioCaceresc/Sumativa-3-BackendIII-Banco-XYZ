package com.banco.xyz.controller;

import com.banco.xyz.dto.TransaccionLigeraDto;
import com.banco.xyz.repository.ResumenTransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mobile")
public class MobileBffController {

    @Autowired
    private ResumenTransaccionRepository transaccionRepository;

    @GetMapping("/transacciones")
    public ResponseEntity<List<TransaccionLigeraDto>> getTransaccionesLigeras() {
        // Transformé la respuesta a un DTO ligero para ahorrar ancho de banda en la versión móvil.
        List<TransaccionLigeraDto> transacciones = transaccionRepository.findAll().stream()
                .map(t -> new TransaccionLigeraDto(t.getId(), t.getMonto(), t.getTipo()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(transacciones);
    }
}
