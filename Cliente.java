package com.barbearia.model;

import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nome;
    private String telefone;
    private String email;

    public Cliente(String nome, String telefone, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters and Setters
    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
}
