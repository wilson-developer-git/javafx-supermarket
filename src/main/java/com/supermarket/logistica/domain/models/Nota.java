package com.supermarket.logistica.domain.models;

import com.supermarket.logistica.domain.models.enums.TipoNota;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String numero;
    private Double total;

    @Enumerated(value = EnumType.STRING)
    private TipoNota tipoNota;

    @Override
    public String toString() {
        return numero;
    }

}
