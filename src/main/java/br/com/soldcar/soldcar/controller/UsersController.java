package br.com.soldcar.soldcar.controller;

import br.com.soldcar.soldcar.dto.UserResponseDTO;
import br.com.soldcar.soldcar.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/buscarTodosOsUsuarios")
    @SecurityRequirement(name = "Bearer Authentication")
    public List<UserResponseDTO> buscaTodosOsCarros() {
        List<UserResponseDTO> listaTodosOsUsuarios = userService.buscarTodosOsUsuarios();
        return new ResponseEntity<>(listaTodosOsUsuarios, HttpStatus.OK).getBody();
    }

    @DeleteMapping("/{userId}")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deletarUsuario(userId);
        return ResponseEntity.ok("Usuário deletado com sucesso");
    }

}
