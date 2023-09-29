package br.com.soldcar.soldcar.service.impl;

import br.com.soldcar.soldcar.dto.UserResponseDTO;
import br.com.soldcar.soldcar.model.user.User;
import br.com.soldcar.soldcar.repository.UserRepository;
import br.com.soldcar.soldcar.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserResponseDTO> buscarTodosOsUsuarios() {
        List<User> listaTodosOsUsuarios = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : listaTodosOsUsuarios) {
            UserResponseDTO userResponseDTO = UserResponseDTO.builder()
                    .id(user.getId().toString())
                    .login(user.getLogin())
                    .email(user.getEmail())
                    .nome(user.getNome())
                    .sobrenome(user.getSobrenome())
                    .role(user.getRole().toString())
                    .build();
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    @Override
    public void deletarUsuario(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            userRepository.delete(user);
        }
    }

}
