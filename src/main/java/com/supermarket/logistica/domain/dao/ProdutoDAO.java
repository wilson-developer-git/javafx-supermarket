package com.supermarket.logistica.domain.dao;

import com.supermarket.logistica.domain.models.Produto;
import com.supermarket.conexao_db.ConectionDB;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProdutoDAO {

    public static List<Produto> listarProdutosPontoReposicao(){

        ConectionDB conectionDB = new ConectionDB();

        EntityManager entityManager = conectionDB.abrirConexao();
        TypedQuery<Produto> query = entityManager.createQuery(
                "from Produto p where p.quantidade <= p.pontoReposicao", Produto.class);
        List<Produto> lista = query.getResultList();
        conectionDB.fecharConexao(entityManager);
        return lista;
    }

}
