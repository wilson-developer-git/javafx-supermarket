package com.supermarket.logistica.domain.dao;

import com.supermarket.logistica.domain.models.UnidadeMedida;
import com.supermarket.conexao_db.ConectionDB;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UnidadeMedidaDAO {


    public static List<UnidadeMedida> listarUnidadesMedida() {
        ConectionDB conectionDB = new ConectionDB();
        EntityManager entityManager = conectionDB.abrirConexao();
        TypedQuery<UnidadeMedida> query = entityManager.createQuery(
                "from UnidadeMedida", UnidadeMedida.class);
        List<UnidadeMedida> lista = query.getResultList();
        conectionDB.fecharConexao(entityManager);
        return lista;
    }

}
