package br.com.soldcar.soldcar.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private String login;
    private String password;
    private String nome;
    private String sobrenome;
    private String email;
    private UserRole role;

}
