package com.barbearia.service;

import com.barbearia.model.Agendamento;
import com.barbearia.model.AgendamentoStatus;
import com.barbearia.strategy.ValidacaoStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AgendamentoService {
    private List<Agendamento> agendamentosRepo = new ArrayList<>();
    private List<ValidacaoStrategy> validacoes;

    public AgendamentoService(List<ValidacaoStrategy> validacoes) {
        this.validacoes = validacoes;
    }

    public void agendar(Agendamento agendamento) {
        for (ValidacaoStrategy validacao : validacoes) {
            validacao.validar(agendamento, agendamentosRepo);
        }
        agendamentosRepo.add(agendamento);
    }

    public void cancelar(UUID idAgendamento) {
        agendamentosRepo.stream()
                .filter(a -> a.getId().equals(idAgendamento))
                .findFirst()
                .ifPresent(a -> a.alterarStatus(AgendamentoStatus.CANCELADO));
    }

    public List<Agendamento> listarPorBarbeiro(UUID barbeiroId) {
        return agendamentosRepo.stream()
                .filter(a -> a.getBarbeiro().getId().equals(barbeiroId))
                .collect(Collectors.toList());
    }

    public List<Agendamento> getAgendamentos() {
        return new ArrayList<>(agendamentosRepo);
    }
}
