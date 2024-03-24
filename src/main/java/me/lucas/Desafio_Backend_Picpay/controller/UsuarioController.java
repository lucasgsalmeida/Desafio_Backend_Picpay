package me.lucas.Desafio_Backend_Picpay.controller;

import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.UsuarioRequestDTO;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.UsuarioResponseDTO;
import me.lucas.Desafio_Backend_Picpay.model.repository.UsuarioRepository;
import me.lucas.Desafio_Backend_Picpay.service.TokenService;
import me.lucas.Desafio_Backend_Picpay.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity registrarNovoUsuario(@RequestBody @Validated UsuarioRequestDTO data) {
        return usuarioService.registrarUsuario(data);
    }

    @PostMapping("/login")
    public ResponseEntity fazerLogin(@RequestBody @Validated UsuarioResponseDTO data) {
        return usuarioService.fazerLogin(data);
    }


}
