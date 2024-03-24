package me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JoinColumn(table = "Usuario", name = "id")
    private UUID usuarioEnviador;

    @JoinColumn(table = "Usuario", name = "id")
    private UUID usuarioRecebedor;

    private Double valor;

    public Transaction(TransactionRequestDTO transaction) {
        this.usuarioEnviador = transaction.usuarioEnviador();
        this.usuarioRecebedor = transaction.usuarioRecebedor();
        this.valor = transaction.valor();
    }

}
