package com.supermarket.logistica.domain.services;

import com.supermarket.logistica.domain.dao.CategoriaDAO;
import com.supermarket.logistica.domain.models.Categoria;
import com.supermarket.conexao_db.CRUD;

import java.util.List;

public class CategoriaService {

    public static List<Categoria> listarCategorias(){
        return CategoriaDAO.listarCategorias();
    }

    public static void cadastrarCategoria(Categoria categoria){
        CRUD.save(categoria);
    }

}
