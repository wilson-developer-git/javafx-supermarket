package com.supermarket.logistica.domain.services;

import com.supermarket.logistica.domain.dao.NotaDAO;
import com.supermarket.logistica.domain.models.Nota;
import com.supermarket.conexao_db.CRUD;

import java.util.List;

public class NotaService {

    public static List<Nota> listarNotas(){
        return NotaDAO.listarNotasDAO();
    }

    public static void cadastrarNotaService(Nota nota){
        CRUD.save(nota);
    }

}
