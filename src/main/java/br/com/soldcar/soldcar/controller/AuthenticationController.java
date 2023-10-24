package br.com.soldcar.soldcar.controller;

import br.com.soldcar.soldcar.config.TokenService;
import br.com.soldcar.soldcar.dto.ErrorResponseDTO;
import br.com.soldcar.soldcar.mapper.UserMapper;
import br.com.soldcar.soldcar.model.user.*;
import br.com.soldcar.soldcar.repository.UserRepository;
import br.com.soldcar.soldcar.service.UserService;
import br.com.soldcar.soldcar.util.GenericUtils;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private GenericUtils genericUtils;
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO data) {
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
            var auth = authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateToken((User) auth.getPrincipal());
            
            String authorities = auth.getAuthorities().toString();
            
            LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder().userRole(authorities).token(token).build();

            return ResponseEntity.ok(loginResponseDTO);
        } catch (AuthenticationException e) {
            // Se a autenticação falhar, você pode retornar uma mensagem de erro personalizada
            String errorMessage = "Credenciais inválidas. Verifique seu login e sua senha.";
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponseDTO(errorMessage));
        }
    }

    @PostMapping("/register")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){

        if (this.repository.findByLogin(data.getLogin()) != null || this.repository.findByEmail(data.getEmail()) != null) {
            return ResponseEntity.badRequest().body(new RegisterResponseDTO(400, "Usuário já registrado!"));
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        UserRole finalRole = data.getRole() == null ? UserRole.USER : data.getRole() ;
        User newUser = new User(data.getLogin(), encryptedPassword, finalRole, data.getEmail(), data.getNome(), data.getSobrenome());

        this.repository.save(newUser);

        return ResponseEntity.ok(new RegisterResponseDTO(200, "Registro bem-sucedido"));
    }
}
