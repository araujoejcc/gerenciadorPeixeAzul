package br.com.peixeazul.fazendaPeixeAzul.services;


import br.com.peixeazul.fazendaPeixeAzul.models.Tanque;
import br.com.peixeazul.fazendaPeixeAzul.repositories.TanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TanqueService {

    @Autowired
    private TanqueRepository tanqueRepository;

    public List<Tanque> listarTodos(){
        return tanqueRepository.findAll();
    }

    public Optional<Tanque> buscarPorId(Integer id) {
        return tanqueRepository.findById(id);
    }

    public Tanque salvar(Tanque tanque) {
        return tanqueRepository.save(tanque);
    }

    public void deletar(Integer id) {
        tanqueRepository.deleteById(id);
    }

}
