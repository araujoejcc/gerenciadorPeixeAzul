package br.com.peixeazul.gerenciadorPeixeAzul.repositories;

import br.com.peixeazul.gerenciadorPeixeAzul.models.RegistroQualidadeAgua;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroQualidadeAguaRepository extends JpaRepository<RegistroQualidadeAgua, Integer> {

}
