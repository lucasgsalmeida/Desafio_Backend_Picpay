package me.lucas.Desafio_Backend_Picpay.model.domain.usuario;

public enum UserRole {

    COMUM("COMUM"),
    LOJISTA("LOJISTA");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
