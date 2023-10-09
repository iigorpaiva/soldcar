package br.com.soldcar.soldcar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Patio")
@NoArgsConstructor
@AllArgsConstructor
public class Patio extends BaseEntity {

    private String nome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carro_id")
    private Carro carroId;

}
