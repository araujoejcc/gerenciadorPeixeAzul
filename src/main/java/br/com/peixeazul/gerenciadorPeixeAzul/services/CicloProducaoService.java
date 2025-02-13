package br.com.peixeazul.gerenciadorPeixeAzul.services;

import br.com.peixeazul.gerenciadorPeixeAzul.entities.CicloProducao;
import br.com.peixeazul.gerenciadorPeixeAzul.repositories.CicloProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CicloProducaoService {
    private final CicloProducaoRepository cicloRepository;

    @Autowired
    public CicloProducaoService(CicloProducaoRepository cicloRepository) {
        this.cicloRepository = cicloRepository;
    }

    public Optional<List<CicloProducao>> listarTodos() {
        return Optional.of(cicloRepository.findAll());
    }

    public Optional<List<CicloProducao>> listarPorTanque(Integer tanqueId) {
        return Optional.of(cicloRepository.findByTanqueId(tanqueId));
    }

    public Optional<CicloProducao> listarPorId(Integer id){
        return cicloRepository.findById(id);
    }

    public CicloProducao registrarCiclo(CicloProducao ciclo) {
        return cicloRepository.save(ciclo);
    }

    public CicloProducao alterarCiclo(CicloProducao ciclo) {
        return cicloRepository.save(ciclo);
    }

    public void excluirCiclo(Integer id) {
        cicloRepository.deleteById(id);
    }

    public double calcularFCA(Integer cicloId) {
        Optional<CicloProducao> ciclo = cicloRepository.findById(cicloId);
        return ciclo.map(CicloProducao::calcularFCA).orElse(0.0);
    }
}