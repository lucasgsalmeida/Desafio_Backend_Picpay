package me.lucas.Desafio_Backend_Picpay.service;

import jakarta.transaction.Transactional;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.UserRole;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.Usuario;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction.Transaction;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction.TransactionDTO;
import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction.TransactionRequestDTO;
import me.lucas.Desafio_Backend_Picpay.model.repository.TransactionRepository;
import me.lucas.Desafio_Backend_Picpay.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity fazerTransaction(TransactionDTO data) {
        System.out.println(data);
        Usuario usuarioEnviador = usuarioRepository.findUsuarioByEmail(data.usuarioEnviador());
        Usuario usuarioRecebedor = usuarioRepository.findUsuarioByEmail(data.usuarioRecebedor());

        if (usuarioEnviador == null || usuarioRecebedor == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        if (usuarioEnviador.getRole() == UserRole.LOJISTA) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        if (usuarioEnviador.getSaldo() < data.valor()) {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).build();
        }

        usuarioEnviador.setSaldo(usuarioEnviador.getSaldo() - data.valor());
        usuarioRecebedor.setSaldo(usuarioRecebedor.getSaldo() + data.valor());

        TransactionRequestDTO transactionSave = new TransactionRequestDTO(usuarioEnviador.getId(), usuarioRecebedor.getId(), data.valor());
        Transaction transaction = new Transaction(transactionSave);

        repository.save(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
