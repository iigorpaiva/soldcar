package br.com.soldcar.soldcar.service;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.dto.CarroResponseDTO;
import br.com.soldcar.soldcar.model.Carro;

import java.util.List;

public interface CarroService {
    /**
     * Método para buscar todos os carros pelo modelo
     * @param modelo O nome do modelo usado como referÊncia na busca
     * @return Lista de carros
     */
    List<Carro> buscarCarrosPorModelo(String modelo);
    
    /**
     * Método para buscar todos os carros pelo pátio
     * @param patioId O Id do pátio usado como referÊncia na busca
     * @return Lista de carros
     */
    List<CarroResponseDTO> buscarCarrosPorPatio(Integer patioId);
    
    Carro inserirCarro(CarroRequestDTO carroRequestDTO);

    /**
     * Método que busca todos os carros
     * @return Lista de Carros
     */
    List<Carro> buscarTodosOsCarros();

}
