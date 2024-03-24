package me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction;

import java.util.UUID;

public record TransactionResponseDTO(UUID id, UUID usuarioEnviador, UUID usuarioRecebedor, Double valor) {

    public TransactionResponseDTO(Transaction transaction) {
        this(transaction.getId(), transaction.getUsuarioEnviador(), transaction.getUsuarioRecebedor(), transaction.getValor());
    }
}
