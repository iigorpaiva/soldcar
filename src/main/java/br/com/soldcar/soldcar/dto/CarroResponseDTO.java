package br.com.soldcar.soldcar.dto;

import br.com.soldcar.soldcar.enums.Cor;
import br.com.soldcar.soldcar.enums.Marca;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroResponseDTO {
    
    private String modelo;
    private Marca marca;
    private String anoFabricacao;
    private String anoModelo;
    private Cor cor;
    private Long patioId;
    private String caminhoFotos;
}
