package com.supermarket.recursos_humanos.dominio.model;

import com.supermarket.recursos_humanos.dominio.model.enums.EstadoBrasil;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String descricao;
    private Integer cep;

    @Enumerated(value = EnumType.STRING)
    private EstadoBrasil estadoBrasil;

}
