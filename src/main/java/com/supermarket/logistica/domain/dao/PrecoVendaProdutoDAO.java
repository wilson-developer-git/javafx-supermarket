package com.supermarket.logistica.domain.dao;

import com.supermarket.logistica.domain.models.PrecoVendaProduto;
import com.supermarket.conexao_db.ConectionDB;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PrecoVendaProdutoDAO {

    public static List<PrecoVendaProduto> listarPrecosVendaProduto(){

        ConectionDB conectionDB = new ConectionDB();

        EntityManager entityManager = conectionDB.abrirConexao();
        TypedQuery<PrecoVendaProduto> query = entityManager.createQuery(
                "from PrecoVendaProduto", PrecoVendaProduto.class);
        List<PrecoVendaProduto> lista = query.getResultList();
        conectionDB.fecharConexao(entityManager);
        return lista;
    }

}
