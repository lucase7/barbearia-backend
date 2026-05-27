package com.barbearia.factory;

import com.barbearia.model.Servico;
import java.math.BigDecimal;

public class ServicoFactory {
    public static Servico criarCorteSimples() {
        return new Servico("Corte", "Corte de cabelo simples", 30, new BigDecimal("30.00"));
    }

    public static Servico criarBarbaCompleta() {
        return new Servico("Barba", "Serviço de barba completo", 20, new BigDecimal("20.00"));
    }
}
