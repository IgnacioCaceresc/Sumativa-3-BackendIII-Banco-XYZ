package com.banco.xyz.controller;

import com.banco.xyz.dto.JwtResponse;
import com.banco.xyz.dto.LoginRequest;
import com.banco.xyz.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.xyz.model.entity.Usuario;
import com.banco.xyz.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        
        Usuario usuario = usuarioRepository.findById(loginRequest.getUsername()).orElse(null);
        
        if (usuario == null || !passwordEncoder.matches(loginRequest.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }

        String jwt = jwtUtils.generateJwtToken(usuario.getUsername(), usuario.getRole());

        return ResponseEntity.ok(new JwtResponse(jwt, usuario.getUsername(), usuario.getRole()));
    }
}
