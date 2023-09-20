package br.com.soldcar.soldcar.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterResponseDTO {

    private Integer status;
    private String message;
}
