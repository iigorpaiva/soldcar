package br.com.soldcar.soldcar.service;

import br.com.soldcar.soldcar.dto.PatioRequestDTO;
import br.com.soldcar.soldcar.dto.PatioResponseDTO;
import br.com.soldcar.soldcar.model.Patio;

import java.util.List;

public interface PatioService {


    /**
     * Método para persistir um novo patio
     * @param patioRequestDTO Objeto passado para ser persistido
     * @return Carro O novo carro criado
     */
    Patio inserirPatio(PatioRequestDTO patioRequestDTO);

    /**
     * Método que busca todos os pátios
     * @return Lista de Patio
     */
    List<PatioResponseDTO> buscarTodosOsPatios();
}
