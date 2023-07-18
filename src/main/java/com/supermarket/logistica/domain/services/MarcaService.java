package com.supermarket.logistica.domain.services;

import com.supermarket.logistica.domain.dao.MarcaDAO;
import com.supermarket.logistica.domain.models.Marca;
import com.supermarket.conexao_db.CRUD;

import java.util.List;

public class MarcaService {

    public static List<Marca> listarMarcas(){
        return MarcaDAO.listarMarcas();
    }

    public static void cadastrarMarca(Marca marca){
        CRUD.save(marca);
    }

}
