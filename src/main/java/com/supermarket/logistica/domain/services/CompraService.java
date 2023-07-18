package com.supermarket.logistica.domain.services;

import com.supermarket.conexao_db.CRUD;
import com.supermarket.logistica.domain.dao.CompraDAO;
import com.supermarket.logistica.domain.dao.MarcaDAO;
import com.supermarket.logistica.domain.models.Compra;
import com.supermarket.logistica.domain.models.Marca;

import java.util.List;

public class CompraService {

    public static List<Compra> listarCompra(){
        return CompraDAO.listarCompra();
    }

    public static void cadastrarCompra(Compra compra){
        CRUD.save(compra);
    }

}
