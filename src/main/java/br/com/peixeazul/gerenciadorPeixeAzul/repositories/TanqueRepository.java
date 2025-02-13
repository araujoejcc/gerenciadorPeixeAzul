package br.com.peixeazul.gerenciadorPeixeAzul.repositories;

import br.com.peixeazul.gerenciadorPeixeAzul.entities.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TanqueRepository extends JpaRepository <Tanque, Integer> {

    void deleteById(Integer id);

    Optional<Tanque> findById(Integer id);
}
