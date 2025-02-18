package br.com.peixeazul.fazendaPeixeAzul.services;
import br.com.peixeazul.fazendaPeixeAzul.models.RegistroQualidadeAgua;
import br.com.peixeazul.fazendaPeixeAzul.repositories.RegistroQualidadeAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroQualidadeAguaService {

    @Autowired
    private RegistroQualidadeAguaRepository registroQualidadeAguaRepository;

    public List<RegistroQualidadeAgua> listarTodos(){
        return registroQualidadeAguaRepository.findAll();
    }

    public Optional<RegistroQualidadeAgua> buscarPorId(Integer id) {
        return registroQualidadeAguaRepository.findById(id);
    }

    public RegistroQualidadeAgua salvar(RegistroQualidadeAgua registroQualidadeAgua) {
        return registroQualidadeAguaRepository.save(registroQualidadeAgua);
    }

    public void deletar(Integer id) {
        registroQualidadeAguaRepository.deleteById(id);
    }
}
