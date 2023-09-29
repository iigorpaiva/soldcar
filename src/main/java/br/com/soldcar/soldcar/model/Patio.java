package br.com.soldcar.soldcar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

}
