package br.com.soldcar.soldcar.mapper;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.dto.CarroResponseDTO;
import br.com.soldcar.soldcar.model.Carro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarroMapper {

    /**
     * Representa a instância da classe
     */
    CarroMapper INSTANCE = Mappers.getMapper(CarroMapper.class);
    /**
     *
     * @param carroRequestDTO O objeto a ser convertido
     * @return Carro O objeto de destino convertido
     */
    //@Mapping(source = "nomeMarca", target = "marca.nome") // Mapeia para o nome da marca
    //@Mapping(source = "nomeCor", target = "cor.nome") // Mapeia para o nome da cor
    Carro carroRequestDTOtoCarro(CarroRequestDTO carroRequestDTO);
    
    @Mappings({
            @Mapping(source = "patio.id", target = "patioId"),
    })
    CarroResponseDTO carroToCarroResponseDTO(Carro carro);
    
    
    /**
     *
     * @param carroList List de Objeto Carro a ser convertido
     * @return Lista de CarroResponseDTO convertido
     */
    List<CarroResponseDTO> carrosToCarroResponseDTOs(List<Carro> carroList);
}
