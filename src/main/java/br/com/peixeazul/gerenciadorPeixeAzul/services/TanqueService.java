package br.com.peixeazul.gerenciadorPeixeAzul.services;

import br.com.peixeazul.gerenciadorPeixeAzul.entities.Tanque;
import br.com.peixeazul.gerenciadorPeixeAzul.repositories.TanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TanqueService {
    private final TanqueRepository tanqueRepository;

    @Autowired
    public TanqueService(TanqueRepository tanqueRepository) {
        this.tanqueRepository = tanqueRepository;
    }

    public Optional<List<Tanque>> listarTanques() {
        return Optional.of(tanqueRepository.findAll());
    }

    public Optional<Tanque> buscarPorId(Integer id){
        return tanqueRepository.findById(id);
    }

    public Tanque salvarTanque(Tanque tanque) {
        return tanqueRepository.save(tanque);
    }

    public Tanque alterarTanque(Tanque tanque) {
        return tanqueRepository.save(tanque);
    }

    public void excluirTanque(Integer id) {
        tanqueRepository.deleteById(id);
    }
}
