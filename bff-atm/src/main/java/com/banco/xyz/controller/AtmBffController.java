package com.banco.xyz.controller;

import com.banco.xyz.model.entity.InteresMensual;
import com.banco.xyz.repository.InteresMensualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.banco.xyz.dto.AtmSaldoDto;
import com.banco.xyz.exception.InvalidDataException;

@RestController
@RequestMapping("/api/atm")
public class AtmBffController {

    @Autowired
    private InteresMensualRepository cuentaRepository;

    @GetMapping("/saldo/{cuentaId}")
    public ResponseEntity<AtmSaldoDto> consultarSaldoCritico(@PathVariable String cuentaId) {
        Optional<InteresMensual> cuenta = cuentaRepository.findById(cuentaId);
        if (cuenta.isPresent()) {
            AtmSaldoDto response = new AtmSaldoDto(cuenta.get().getCuentaId(), cuenta.get().getSaldoFinal());
            return ResponseEntity.ok(response);
        }
        throw new InvalidDataException("Cuenta no encontrada o error de seguridad.");
    }
}
