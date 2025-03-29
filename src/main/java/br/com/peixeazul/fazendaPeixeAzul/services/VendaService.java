package br.com.peixeazul.fazendaPeixeAzul.services;

import br.com.peixeazul.fazendaPeixeAzul.models.Venda;
import br.com.peixeazul.fazendaPeixeAzul.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarTodos(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> buscarPorId(Integer id) {
        return vendaRepository.findById(id);
    }

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void deletar(Integer id) {
        vendaRepository.deleteById(id);
    }

}

