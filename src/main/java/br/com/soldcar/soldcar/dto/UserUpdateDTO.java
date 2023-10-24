package br.com.soldcar.soldcar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    private String id;
    private String login;
    private String email;
    private String nome;
    private String sobrenome;

}
