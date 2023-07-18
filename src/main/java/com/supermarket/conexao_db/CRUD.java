package com.supermarket.conexao_db;

import com.supermarket.recursos_humanos.dominio.model.Cidade;

import javax.persistence.EntityManager;

public interface CRUD {

    public static void save(Object object){
        ConectionDB conectionDB = new ConectionDB();
        EntityManager entityManager = conectionDB.abrirConexao();
            entityManager.getTransaction().begin();
                entityManager.persist(object);
            entityManager.getTransaction().commit();
        conectionDB.fecharConexao(entityManager);
    }

    public static Cidade readId(Long id){
        ConectionDB conectionDB = new ConectionDB();
        EntityManager entityManager = conectionDB.abrirConexao();
        Cidade cid01 = entityManager.find(Cidade.class, id);
        conectionDB.fecharConexao(entityManager);
        return cid01;
    }



}
