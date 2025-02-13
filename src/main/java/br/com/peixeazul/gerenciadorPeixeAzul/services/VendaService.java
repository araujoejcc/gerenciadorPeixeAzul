package br.com.peixeazul.gerenciadorPeixeAzul.services;

import br.com.peixeazul.gerenciadorPeixeAzul.entities.Venda;
import br.com.peixeazul.gerenciadorPeixeAzul.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Optional<List<Venda>> listarPorTanque(Integer tanqueId) {
        return Optional.of(vendaRepository.findByTanqueId(tanqueId));
    }

    public Optional<List<Venda>> listarTodas(){
        return Optional.of(vendaRepository.findAll());
    }

    public Optional<Venda> buscarPorId(Integer id){
        return vendaRepository.findById(id);
    }

    public Venda registrarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    public void excluirVenda (Integer id){
        vendaRepository.deleteById(id);
    }

}

