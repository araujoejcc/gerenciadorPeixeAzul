package br.com.peixeazul.gerenciadorPeixeAzul.services;

import br.com.peixeazul.gerenciadorPeixeAzul.entities.Compra;
import br.com.peixeazul.gerenciadorPeixeAzul.entities.Tanque;
import br.com.peixeazul.gerenciadorPeixeAzul.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    private final CompraRepository compraRepository;

    @Autowired
    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Optional<List<Compra>> listarTodas() {
        return Optional.of(compraRepository.findAll());
    }

    public Optional<Compra> buscarPorId(Integer id){
        return compraRepository.findById(id);
    }

    public Compra registrarCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public Compra alterarCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public void excluirCompra(Integer id) {
        compraRepository.deleteById(id);
    }
}
