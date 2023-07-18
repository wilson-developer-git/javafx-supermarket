package com.supermarket.logistica.domain.models;

import com.supermarket.logistica.domain.models.enums.Departamento;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Departamento departamento;

    @Override
    public String toString() {
        return descricao;
    }
}
