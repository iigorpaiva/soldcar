package br.com.soldcar.soldcar.service;

import br.com.soldcar.soldcar.dto.UserResponseDTO;
import br.com.soldcar.soldcar.dto.UserUpdateDTO;
import br.com.soldcar.soldcar.model.user.User;

import java.util.List;

public interface UserService {

    /**
     * Método que busca todos os usuários
     * @return Lista de Usuários
     */
    List<UserResponseDTO> buscarTodosOsUsuarios();

    /**
     * Deleta usuário existente
     * @param userId
     */
    void deletarUsuario(Long userId);
    
    /**
     * Método usado para editar campos de um usuário no Soldcar
     * @param userUpdateDTO
     * @return User
     */
    User editarUsuario(Long userId, UserUpdateDTO userUpdateDTO);
}
