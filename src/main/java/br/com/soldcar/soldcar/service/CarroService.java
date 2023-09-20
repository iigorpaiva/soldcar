package br.com.soldcar.soldcar.service;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.model.Carro;

import java.util.List;

public interface CarroService {
    /**
     * Método para buscar todos os carros pelo modelo
     * @param modelo O nome do modelo do carro
     * @return Lista de carros
     */
    List<Carro> buscarCarroPorModelo(String modelo);

    /**
     * Método para persistir um novo carro
     * @param carroRequestDTO Objeto passado para ser persistido
     * @return Carro O novo carro criado
     */
    Carro inserirCarro(CarroRequestDTO carroRequestDTO);

    /**
     * Método que busca todos os carros
     * @return Lista de Carros
     */
    List<Carro> buscarTodosOsCarros();
}
