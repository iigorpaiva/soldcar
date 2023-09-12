package br.com.soldcar.soldcar.service;

import br.com.soldcar.soldcar.model.Carro;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

public interface CarroService {

    List<Carro> buscarCarroPorNome(String modelo);
    Carro inserirCarro(Carro carro);
}
