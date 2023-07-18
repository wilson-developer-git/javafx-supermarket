package com.supermarket.logistica.domain.dao;

import com.supermarket.logistica.domain.models.Localizacao;
import com.supermarket.conexao_db.ConectionDB;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class LocalizacaoDAO {

    public static List<Localizacao> listarLocalizacoes(){

        ConectionDB conectionDB = new ConectionDB();

        EntityManager entityManager = conectionDB.abrirConexao();
        TypedQuery<Localizacao> query = entityManager.createQuery(
                "from Localizacao", Localizacao.class);
        List<Localizacao> lista = query.getResultList();
        conectionDB.fecharConexao(entityManager);
        return lista;
    }

}
