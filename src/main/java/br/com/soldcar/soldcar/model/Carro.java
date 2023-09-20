package br.com.soldcar.soldcar.model;

import br.com.soldcar.soldcar.enums.Cor;
import br.com.soldcar.soldcar.enums.Marca;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Carro")
@NoArgsConstructor
@AllArgsConstructor
public class Carro extends BaseEntity {

    private String modelo;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private String anoFabricacao;

    private String anoModelo;

    @Enumerated(EnumType.STRING)
    private Cor cor;

}
