package com.supermarket.testes.rh_testes;

import com.supermarket.conexao_db.CRUD;
import com.supermarket.recursos_humanos.dominio.model.Cidade;
import com.supermarket.recursos_humanos.dominio.model.enums.EstadoBrasil;

public class AppTeste {

    public static void main(String[] args) {

        Cidade cid01 = new Cidade();
        cid01.setDescricao("Dias Davila");
        cid01.setEstadoBrasil(EstadoBrasil.Bahia_BA);
        cid01.setCep(42850000);

        CRUD.save(cid01);

        System.out.println(CRUD.readId(cid01.getId()));


    }

}
