package br.com.soldcar.soldcar.mapper;

import br.com.soldcar.soldcar.dto.UserUpdateDTO;
import br.com.soldcar.soldcar.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    /**
     * Representa a instância da classe
     */
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    User userUpdateDTOToUser(UserUpdateDTO userUpdateDTO);
}
