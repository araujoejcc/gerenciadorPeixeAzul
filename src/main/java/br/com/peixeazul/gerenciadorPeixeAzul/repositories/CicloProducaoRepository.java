package br.com.peixeazul.gerenciadorPeixeAzul.repositories;

import br.com.peixeazul.gerenciadorPeixeAzul.models.CicloProducao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CicloProducaoRepository extends JpaRepository<CicloProducao, Integer> {
}
