package me.lucas.Desafio_Backend_Picpay.model.domain.usuario;

import java.util.UUID;

public record UsuarioResponseDTO(UUID id, String nomeCompleto, String cpf, String email, String senha, Double saldo, UserRole role) {

    public UsuarioResponseDTO(Usuario usuarioComum) {
        this(usuarioComum.getId(), usuarioComum.getNomeCompleto(), usuarioComum.getCpf(), usuarioComum.getEmail(), usuarioComum.getSenha(), usuarioComum.getSaldo(), usuarioComum.getRole());
    }

}
