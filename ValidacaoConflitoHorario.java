package com.barbearia.strategy;

import com.barbearia.model.Agendamento;
import com.barbearia.model.AgendamentoStatus;
import java.time.LocalDateTime;
import java.util.List;

public class ValidacaoConflitoHorario implements ValidacaoStrategy {
    @Override
    public void validar(Agendamento agendamento, List<Agendamento> agendamentosExistentes) {
        LocalDateTime inicioNovo = agendamento.getDataHora();
        LocalDateTime fimNovo = inicioNovo.plusMinutes(agendamento.getServico().getDuracaoMinutos());

        for (Agendamento existente : agendamentosExistentes) {
            if (existente.getStatus() == AgendamentoStatus.CANCELADO) continue;
            if (!existente.getBarbeiro().getId().equals(agendamento.getBarbeiro().getId())) continue;

            LocalDateTime inicioExistente = existente.getDataHora();
            LocalDateTime fimExistente = inicioExistente.plusMinutes(existente.getServico().getDuracaoMinutos());

            if (inicioNovo.isBefore(fimExistente) && fimNovo.isAfter(inicioExistente)) {
                throw new RuntimeException("Conflito de horário para o barbeiro selecionado.");
            }
        }
    }
}
