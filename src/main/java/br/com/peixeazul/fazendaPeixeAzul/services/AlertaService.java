package br.com.peixeazul.fazendaPeixeAzul.services;

import br.com.peixeazul.fazendaPeixeAzul.models.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertaService {
    // TODO Injetar dependências necessárias

    public List<AlertaParametro> verificarParametros(RegistroQualidadeAgua registro) {
        // TODO - Lógica para verificar parâmetros e gerar alertas
        return List.of();
    }
}