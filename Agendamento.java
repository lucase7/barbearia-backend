package com.barbearia.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Agendamento {
    private UUID id;
    private Cliente cliente;
    private Barbeiro barbeiro;
    private Servico servico;
    private LocalDateTime dataHora;
    private AgendamentoStatus status;

    public Agendamento(Cliente cliente, Barbeiro barbeiro, Servico servico, LocalDateTime dataHora) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.servico = servico;
        this.dataHora = dataHora;
        this.status = AgendamentoStatus.CONFIRMADO;
    }

    public void alterarStatus(AgendamentoStatus novoStatus) {
        this.status = novoStatus;
    }

    // Getters
    public UUID getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Barbeiro getBarbeiro() { return barbeiro; }
    public Servico getServico() { return servico; }
    public LocalDateTime getDataHora() { return dataHora; }
    public AgendamentoStatus getStatus() { return status; }
}
