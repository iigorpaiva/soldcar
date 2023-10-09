package br.com.soldcar.soldcar.repository;

import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatioRepository extends JpaRepository<Patio, Long> {

    List<Patio> findByNome(String nome);

}
