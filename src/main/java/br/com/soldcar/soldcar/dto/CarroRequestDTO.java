package br.com.soldcar.soldcar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroRequestDTO {

    private String modelo;
    private String marca;
    private String anoFabricacao;
    private String anoModelo;
    private String cor;

}
