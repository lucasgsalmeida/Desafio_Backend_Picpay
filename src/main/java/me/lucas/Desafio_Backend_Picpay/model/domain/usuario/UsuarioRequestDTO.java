package me.lucas.Desafio_Backend_Picpay.model.domain.usuario;

public record UsuarioRequestDTO(String nomeCompleto, String cpf, String email, String senha, Double saldo, UserRole role)
{

}
