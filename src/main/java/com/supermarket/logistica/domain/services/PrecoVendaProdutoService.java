package com.supermarket.logistica.domain.services;

import com.supermarket.logistica.domain.dao.PrecoVendaProdutoDAO;
import com.supermarket.logistica.domain.models.PrecoVendaProduto;
import com.supermarket.conexao_db.CRUD;

import java.util.List;

public class PrecoVendaProdutoService {

    public static List<PrecoVendaProduto> listarPrecosVendaProduto(){
        return PrecoVendaProdutoDAO.listarPrecosVendaProduto();
    }

    public static void cadastrarPrecoVendaProduto(PrecoVendaProduto precoVendaProduto){
        CRUD.save(precoVendaProduto);
    }

}
