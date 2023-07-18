package com.supermarket.logistica.domain.dao;

import com.supermarket.logistica.domain.models.Nota;
import com.supermarket.conexao_db.ConectionDB;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class NotaDAO {

    public static List<Nota> listarNotasDAO(){

        ConectionDB conectionDB = new ConectionDB();

        EntityManager entityManager = conectionDB.abrirConexao();
        TypedQuery<Nota> query = entityManager.createQuery(
                "from Nota", Nota.class);
        List<Nota> lista = query.getResultList();
        conectionDB.fecharConexao(entityManager);
        return lista;
    }

}
