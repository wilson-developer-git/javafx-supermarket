package com.supermarket.logistica.domain.services;

import com.supermarket.logistica.domain.dao.ProdutoDAO;
import com.supermarket.logistica.domain.models.Produto;
import com.supermarket.conexao_db.CRUD;

import java.util.List;

public class ProdutoService {

    public static List<Produto> listarProdutos(){
        return ProdutoDAO.listarProdutosPontoReposicao();
    }

    public static void cadastrarProduto(Produto produto){
        produto.setQuantidade(0.0);
        CRUD.save(produto);
    }

}
