package com.barbearia.model;

import java.util.UUID;

public class Barbeiro {
    private UUID id;
    private String nome;
    private String telefone;
    private String especialidade;

    public Barbeiro(String nome, String telefone, String especialidade) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.telefone = telefone;
        this.especialidade = especialidade;
    }

    // Getters
    public UUID getId() { return id; }
    public String getNome() { return nome; }
}
