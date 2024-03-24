package me.lucas.Desafio_Backend_Picpay.model.domain.usuario;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nomeCompleto;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String senha;

    private Double saldo;

    private UserRole role;


    public Usuario(UsuarioRequestDTO usuarioRegisterDTO, String encSenha) {
        this.nomeCompleto = usuarioRegisterDTO.nomeCompleto();
        this.cpf = usuarioRegisterDTO.cpf();
        this.email = usuarioRegisterDTO.email();
        this.senha = encSenha;
        this.saldo = usuarioRegisterDTO.saldo();
        this.role = usuarioRegisterDTO.role();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.LOJISTA) {
            return List.of(new SimpleGrantedAuthority("ROLE_LOJISTA"), new SimpleGrantedAuthority("ROLE_LOJISTA"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_COMUM"));
        }
    }
    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
