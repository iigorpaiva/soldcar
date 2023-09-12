package br.com.soldcar.soldcar.repository;

import br.com.soldcar.soldcar.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByModelo(String modelo);

}
