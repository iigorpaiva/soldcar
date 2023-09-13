package br.com.soldcar.soldcar.mapper;

import br.com.soldcar.soldcar.dto.CarroRequestDTO;
import br.com.soldcar.soldcar.model.Carro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarroMapper {
    /**
     *
     * @param carroRequestDTO O objeto a ser convertido
     * @return Carro O objeto de destino convertido
     */
    Carro carroRequestDTOtoCarro(CarroRequestDTO carroRequestDTO);
}
