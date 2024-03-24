package me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction;

import java.util.UUID;

public record TransactionRequestDTO(UUID usuarioEnviador, UUID usuarioRecebedor, Double valor) {
}
