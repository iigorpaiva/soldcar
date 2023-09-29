package br.com.soldcar.soldcar.model;

import br.com.soldcar.soldcar.enums.Cor;
import br.com.soldcar.soldcar.enums.Marca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Carro")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carro extends BaseEntity {

    private String modelo;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private String anoFabricacao;

    private String anoModelo;

    @Enumerated(EnumType.STRING)
    private Cor cor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patio_id")
    private Patio patio;

}
