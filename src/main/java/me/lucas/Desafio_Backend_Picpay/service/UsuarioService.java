package me.lucas.Desafio_Backend_Picpay.service;

import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.LoginResponseDTO;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.Usuario;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.UsuarioRequestDTO;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.UsuarioResponseDTO;
import me.lucas.Desafio_Backend_Picpay.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;


    public ResponseEntity registrarUsuario(UsuarioRequestDTO data) {
        if(this.repository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encPass = new BCryptPasswordEncoder().encode(data.senha());
        Usuario users = new Usuario(data, encPass);

        this.repository.save(users);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity fazerLogin(UsuarioResponseDTO data) {
        var userpw = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(userpw);

        var token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
