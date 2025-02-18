package br.com.peixeazul.fazendaPeixeAzul.repositories;

import br.com.peixeazul.fazendaPeixeAzul.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
