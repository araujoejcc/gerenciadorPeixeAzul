package br.com.peixeazul.gerenciadorPeixeAzul.repositories;

import br.com.peixeazul.gerenciadorPeixeAzul.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
