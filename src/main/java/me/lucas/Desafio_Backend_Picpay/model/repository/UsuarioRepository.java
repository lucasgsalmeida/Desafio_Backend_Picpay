package me.lucas.Desafio_Backend_Picpay.model.repository;

import me.lucas.Desafio_Backend_Picpay.model.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    UserDetails findByEmail(String email);

    @Query("SELECT usu FROM Usuario usu WHERE usu.email = :email")
    Usuario findUsuarioByEmail(@Param("email") String email);
}
