package me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction;

import java.util.UUID;

public record TransactionDTO(String usuarioEnviador, String usuarioRecebedor, Double valor) {
}
