package com.barbearia.service;

import com.barbearia.model.*;
import com.barbearia.factory.ServicoFactory;
import com.barbearia.strategy.ValidacaoConflitoHorario;
import com.barbearia.strategy.ValidacaoStrategy;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoServiceTest {

    public static void main(String[] args) {
        testDeveAgendarComSucesso();
        testNaoDeveAgendarComConflitoDeHorario();
        System.out.println("Todos os testes passaram!");
    }

    public static void testDeveAgendarComSucesso() {
        AgendamentoService service = new AgendamentoService(List.of(new ValidacaoConflitoHorario()));
        Cliente cliente = new Cliente("João", "123456", "joao@email.com");
        Barbeiro barbeiro = new Barbeiro("Carlos", "654321", "Corte");
        Servico servico = ServicoFactory.criarCorteSimples();
        
        Agendamento agendamento = new Agendamento(cliente, barbeiro, servico, LocalDateTime.now());
        service.agendar(agendamento);

        if (service.getAgendamentos().size() != 1) {
            throw new RuntimeException("Falha no teste: Agendamento não realizado.");
        }
        System.out.println("Teste 'testDeveAgendarComSucesso' passou.");
    }

    public static void testNaoDeveAgendarComConflitoDeHorario() {
        AgendamentoService service = new AgendamentoService(List.of(new ValidacaoConflitoHorario()));
        Cliente cliente = new Cliente("João", "123456", "joao@email.com");
        Barbeiro barbeiro = new Barbeiro("Carlos", "654321", "Corte");
        Servico servico = ServicoFactory.criarCorteSimples();
        
        LocalDateTime agora = LocalDateTime.now();
        Agendamento agendamento1 = new Agendamento(cliente, barbeiro, servico, agora);
        service.agendar(agendamento1);

        Agendamento agendamento2 = new Agendamento(cliente, barbeiro, servico, agora.plusMinutes(15));
        
        try {
            service.agendar(agendamento2);
            throw new RuntimeException("Falha no teste: Conflito de horário não detectado.");
        } catch (RuntimeException e) {
            if (!e.getMessage().equals("Conflito de horário para o barbeiro selecionado.")) {
                throw e;
            }
        }
        System.out.println("Teste 'testNaoDeveAgendarComConflitoDeHorario' passou.");
    }
}
