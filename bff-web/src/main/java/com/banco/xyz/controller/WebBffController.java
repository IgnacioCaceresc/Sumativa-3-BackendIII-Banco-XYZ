package com.banco.xyz.controller;

import com.banco.xyz.model.entity.ResumenTransaccion;
import com.banco.xyz.repository.ResumenTransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.banco.xyz.dto.WebResumenDto;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/web")
public class WebBffController {

    @Autowired
    private ResumenTransaccionRepository transaccionRepository;

    @GetMapping("/transacciones")
    public ResponseEntity<List<WebResumenDto>> getTransaccionesCompletas() {
        List<ResumenTransaccion> transacciones = transaccionRepository.findAll();
        List<WebResumenDto> response = transacciones.stream()
                .map(t -> new WebResumenDto(t.getId(), t.getFecha(), t.getMonto(), t.getTipo(), t.getEsAnomalia()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
