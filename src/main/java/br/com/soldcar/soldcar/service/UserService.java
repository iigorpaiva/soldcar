package br.com.soldcar.soldcar.service;

import br.com.soldcar.soldcar.dto.UserResponseDTO;

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

}
