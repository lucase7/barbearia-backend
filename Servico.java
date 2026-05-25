package com.barbearia.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Servico {
    private UUID id;
    private String nome;
    private String descricao;
    private int duracaoMinutos;
    private BigDecimal preco;

    public Servico(String nome, String descricao, int duracaoMinutos, BigDecimal preco) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.preco = preco;
    }

    // Getters
    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public BigDecimal getPreco() { return preco; }
}
