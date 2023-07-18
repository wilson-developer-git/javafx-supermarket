package com.supermarket.logistica.domain.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String descricao;
    private Double custo;
    private String codigoBarras;
    private Double quantidade;
    private Integer pontoReposicao;

    @ManyToMany
    @JoinTable(name = "produto_categoria",
            joinColumns = @JoinColumn(name = "id_produto"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Categoria> categorias = new ArrayList<>();

    @ManyToOne
    private Marca marca;

}
