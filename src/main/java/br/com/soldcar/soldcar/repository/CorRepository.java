package br.com.soldcar.soldcar.repository;

import br.com.soldcar.soldcar.model.Carro;
import br.com.soldcar.soldcar.model.Cor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorRepository extends JpaRepository<Cor, Long> {
}
