package com.supermarket.conexao_db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionDB {

    public EntityManager abrirConexao() {
        EntityManagerFactory entityManagerFactory = Persistence.
                            createEntityManagerFactory("supermarket");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public void fecharConexao(EntityManager entityManager) {
        entityManager.getEntityManagerFactory().close();
        entityManager.close();
    }

}
