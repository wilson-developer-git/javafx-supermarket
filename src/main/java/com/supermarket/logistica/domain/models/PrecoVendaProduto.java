package com.supermarket.logistica.domain.models;

import lombok.*;

import javax.persistence.*;

@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor@NoArgsConstructor
@Entity
public class PrecoVendaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private Double preco;
    @ManyToOne
    private UnidadeMedida unidadeMedida;
    @ManyToOne
    private Produto produto;

}
