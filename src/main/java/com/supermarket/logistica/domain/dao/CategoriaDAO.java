package com.supermarket.logistica.domain.dao;

import com.supermarket.logistica.domain.models.Categoria;
import com.supermarket.conexao_db.ConectionDB;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoriaDAO {

    public static List<Categoria> listarCategorias(){

        ConectionDB conectionDB = new ConectionDB();

        EntityManager entityManager = conectionDB.abrirConexao();
        TypedQuery<Categoria> query = entityManager.createQuery(
                "from Categoria", Categoria.class);
        List<Categoria> lista = query.getResultList();
        conectionDB.fecharConexao(entityManager);
        return lista;
    }

}
