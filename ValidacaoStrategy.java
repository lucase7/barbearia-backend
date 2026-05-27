package com.barbearia.strategy;

import com.barbearia.model.Agendamento;
import java.util.List;

public interface ValidacaoStrategy {
    void validar(Agendamento agendamento, List<Agendamento> agendamentosExistentes);
}
