package com.supermarket.comercial.domain.service;

import com.supermarket.comercial.domain.dto.CaixaDTO;
import com.supermarket.comercial.domain.model.Caixa;
import com.supermarket.comercial.domain.model.enums.StatusCaixa;
import com.supermarket.conexao_db.CRUD;

import java.time.LocalDateTime;

public class CaixaService {

    public void abrirNovoCaixa(CaixaDTO caixaDTO){
        Caixa caixa = new Caixa();
        caixa.setDataAbertura(LocalDateTime.now());
        caixa.setStatusCaixa(StatusCaixa.ABERTO);
        caixa.setFundoDeTroco(caixaDTO.getFundoDeTroco());
        CRUD.save(caixa);
    }

    private void validarCaixa(){

    }

}
