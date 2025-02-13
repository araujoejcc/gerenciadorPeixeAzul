package br.com.peixeazul.gerenciadorPeixeAzul.services;

import br.com.peixeazul.gerenciadorPeixeAzul.entities.RegistroQualidadeAgua;
import br.com.peixeazul.gerenciadorPeixeAzul.repositories.RegistroQualidadeAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroQualidadeAguaService {
    private final RegistroQualidadeAguaRepository registroRepository;

    @Autowired
    public RegistroQualidadeAguaService(RegistroQualidadeAguaRepository registroRepository) {
        this.registroRepository = registroRepository;
    }

    public Optional<List<RegistroQualidadeAgua>> listarPorTanque(Integer tanqueId) {
        return Optional.of(registroRepository.findByTanqueId(tanqueId));
    }

    public Optional<List<RegistroQualidadeAgua>> listarTodos(){
        return Optional.of(registroRepository.findAll());
    };

    public Optional<RegistroQualidadeAgua> buscarPorId(Integer id){
        return registroRepository.findById(id);
    }

    public RegistroQualidadeAgua incluirRegistro(RegistroQualidadeAgua registro) {
        return registroRepository.save(registro);
    }

    public void excluirRegistro(Integer id){
        registroRepository.deleteById(id);
    }


}
