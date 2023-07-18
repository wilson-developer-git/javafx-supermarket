package com.supermarket.logistica.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemProdutoRelatorioPedido {

    private Pedido pedido;
    private Produto produto;
    private UnidadeMedida unidadeMedida;
    private int quantidade;

    private Long idProduto;
    private String descricaoProduto;
    private String descricaoUnidadeMedida;


    public ItemProdutoRelatorioPedido(
            Pedido pedido,
            Produto produto,
            int quantidade,
            UnidadeMedida unidadeMedida) {
        this.pedido = pedido;
        this.produto = produto;
        this.idProduto = produto.getId();
        this.descricaoProduto = produto.getDescricao();
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.descricaoUnidadeMedida = unidadeMedida.getDescricao();
    }

}
