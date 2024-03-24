package me.lucas.Desafio_Backend_Picpay.controller;

import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.transaction.TransactionDTO;
import me.lucas.Desafio_Backend_Picpay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity fazerTransaction(@RequestBody TransactionDTO data) {
        System.out.println(data);
        return transactionService.fazerTransaction(data);
    }
}
