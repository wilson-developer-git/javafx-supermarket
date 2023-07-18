package com.supermarket.testes;

import com.supermarket.logistica.domain.models.ItemProdutoRelatorioPedido;
import com.supermarket.logistica.domain.models.Pedido;
import com.supermarket.logistica.domain.models.Produto;
import com.supermarket.logistica.domain.models.UnidadeMedida;
import com.supermarket.logistica.domain.services.ProdutoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        List<ItemProdutoRelatorioPedido> itensPedido = new ArrayList<>();

        Produto p1 = new Produto();
        p1.setDescricao("Celular A03 Samsung");
        p1.setCusto(950.00);
        p1.setCodigoBarras("1259567893698");
        p1.setQuantidade(20.0);
        p1.setPontoReposicao(6);
        //p1.salvar();

        for (Produto p:
            ProdutoService.listarProdutos()) {
            System.out.println(p);
        }



        Pedido pe1 = new Pedido();
        pe1.setId(1L);
        pe1.setPeriodo(LocalDate.now());

        UnidadeMedida und1 = new UnidadeMedida(1L,"Unidade", "UND" );

        //ItemPedido itm1 = new ItemPedido(p1, 1, und1);
       // itensPedido.add(itm1);

        System.out.println(p1);

        System.out.println("*********************** PEDIDOD ***********************");
        System.out.println("");
        System.out.println("ID = " + pe1.getId() + "    Periodo = "+ pe1.getPeriodo());

        System.out.println("");
        System.out.println("************************ Itens *************************");
        for (ItemProdutoRelatorioPedido it: itensPedido
             ) {
            //System.out.println("ID= "+ itm1.getProduto().getId() + "  Qtd= " + itm1.getQuantidade() +  " UM= "+ itm1.getUnidadeMedida().getDescricao());
        }
        System.out.println("");

        System.out.println("************************ RESUMO ************************");
        System.out.println("");


        System.out.println("");
        System.out.println("*****************************************");
    }

}
