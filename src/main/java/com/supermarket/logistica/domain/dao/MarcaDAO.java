package com.supermarket.logistica.domain.dao;

import com.supermarket.logistica.domain.models.Marca;
import com.supermarket.conexao_db.ConectionDB;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MarcaDAO {

    public static List<Marca> listarMarcas(){

        ConectionDB conectionDB = new ConectionDB();

        EntityManager entityManager = conectionDB.abrirConexao();
        TypedQuery<Marca> query = entityManager.createQuery(
                "from Marca", Marca.class);
        List<Marca> lista = query.getResultList();
        conectionDB.fecharConexao(entityManager);
        return lista;
    }

}
