package br.com.peixeazul.gerenciadorPeixeAzul.services;

import br.com.peixeazul.gerenciadorPeixeAzul.models.CicloProducao;
import br.com.peixeazul.gerenciadorPeixeAzul.repositories.CicloProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CicloProducaoService {

    @Autowired
    private CicloProducaoRepository cicloProducaoRepository;

    public List<CicloProducao> listarTodos(){
        return cicloProducaoRepository.findAll();
    }

    public Optional<CicloProducao> buscarPorId(Integer id) {
        return Optional.ofNullable(cicloProducaoRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Ciclo não encontrado com o ID: " + id)));
    }

    public CicloProducao salvar(CicloProducao cicloProducao) {
        return cicloProducaoRepository.save(cicloProducao);
    }

    public void deletar(Integer id) {
        cicloProducaoRepository.deleteById(id);
    }

}