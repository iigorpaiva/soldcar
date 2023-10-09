package br.com.soldcar.soldcar.mapper;

import br.com.soldcar.soldcar.dto.PatioRequestDTO;
import br.com.soldcar.soldcar.dto.PatioResponseDTO;
import br.com.soldcar.soldcar.model.Patio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PatioMapper {

    /**
     * Representa a instância da classe
     */
    PatioMapper INSTANCE = Mappers.getMapper(PatioMapper.class);
    /**
     *
     * @param patioRequestDTO O objeto a ser convertido
     * @return Carro O objeto de destino convertido
     */
    //@Mapping(source = "nomeMarca", target = "marca.nome") // Mapeia para o nome da marca
    //@Mapping(source = "nomeCor", target = "cor.nome") // Mapeia para o nome da cor
    Patio patioRequestDTOtoPatio(PatioRequestDTO patioRequestDTO);
    
    /**
     *
     * @param listPatios Lista de objetos a serem convertidos
     * @return PatioResponseDTO O objeto de destino convertido
     */
    List<PatioResponseDTO> patioToPatioResponseDTO(List<Patio> listPatios);
}
