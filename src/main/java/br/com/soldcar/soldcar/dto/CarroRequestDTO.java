package br.com.soldcar.soldcar.dto;

import br.com.soldcar.soldcar.enums.Cor;
import br.com.soldcar.soldcar.enums.Marca;
import br.com.soldcar.soldcar.enums.PatioEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroRequestDTO {

    private String modelo;
    private Marca marca;
    private String anoFabricacao;
    private String anoModelo;
    private Cor cor;
    private List<MultipartFile> fotos;
    private PatioEnum patio;
}
