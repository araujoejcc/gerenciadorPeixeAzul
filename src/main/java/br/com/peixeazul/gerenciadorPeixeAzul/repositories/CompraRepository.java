package br.com.peixeazul.gerenciadorPeixeAzul.repositories;

import br.com.peixeazul.gerenciadorPeixeAzul.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra,Integer> {
}
