package me.lucas.Desafio_Backend_Picpay.model.repository;

import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
