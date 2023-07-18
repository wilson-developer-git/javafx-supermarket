package com.supermarket.logistica.domain.services;

import com.supermarket.logistica.domain.dao.UnidadeMedidaDAO;
import com.supermarket.logistica.domain.models.UnidadeMedida;
import com.supermarket.conexao_db.CRUD;

import java.util.List;

public class UnidadeMedidaService {


    public static List<UnidadeMedida> listarUnidadesMedida() {
        return UnidadeMedidaDAO.listarUnidadesMedida();
    }

    public static void cadastrarUnidadeMedida(UnidadeMedida unidadeMedida){
        CRUD.save(unidadeMedida);
    }

}
