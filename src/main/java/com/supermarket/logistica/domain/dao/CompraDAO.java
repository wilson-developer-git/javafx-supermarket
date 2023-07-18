package com.supermarket.logistica.domain.dao;

import com.supermarket.conexao_db.ConectionDB;
import com.supermarket.logistica.domain.models.Compra;
import com.supermarket.logistica.domain.models.Marca;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CompraDAO {

    public static List<Compra> listarCompra(){
        ConectionDB conectionDB = new ConectionDB();
        EntityManager entityManager = conectionDB.abrirConexao();
        TypedQuery<Compra> query = entityManager.createQuery(
                "from Compra", Compra.class);
        List<Compra> lista = query.getResultList();
        conectionDB.fecharConexao(entityManager);
        return lista;
    }

}
