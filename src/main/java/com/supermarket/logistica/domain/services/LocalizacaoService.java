package com.supermarket.logistica.domain.services;

import com.supermarket.logistica.domain.dao.LocalizacaoDAO;
import com.supermarket.logistica.domain.models.Localizacao;
import com.supermarket.conexao_db.CRUD;

import java.util.List;

public class LocalizacaoService {

    public static List<Localizacao> listarLocalizacoes(){
        return LocalizacaoDAO.listarLocalizacoes();
    }

    public static void cadastrarLocalizacao(Localizacao localizacao){
        CRUD.save(localizacao);
    }

}
