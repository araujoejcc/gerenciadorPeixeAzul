package br.com.peixeazul.gerenciadorPeixeAzul.services;

import br.com.peixeazul.gerenciadorPeixeAzul.models.CicloProducao;
import br.com.peixeazul.gerenciadorPeixeAzul.models.Compra;
import br.com.peixeazul.gerenciadorPeixeAzul.repositories.CicloProducaoRepository;
import br.com.peixeazul.gerenciadorPeixeAzul.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> listarTodos(){
        return compraRepository.findAll();
    }

    public Optional<Compra> buscarPorId(Integer id) {
        return compraRepository.findById(id);
    }

    public Compra salvar(Compra compra) {
        return compraRepository.save(compra);
    }

    public void deletar(Integer id) {
        compraRepository.deleteById(id);
    }
}
