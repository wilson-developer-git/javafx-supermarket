package com.supermarket.logistica.controls;

import com.supermarket.logistica.domain.models.Compra;
import com.supermarket.logistica.domain.models.Marca;
import com.supermarket.logistica.domain.models.Nota;
import com.supermarket.logistica.domain.services.CompraService;
import com.supermarket.logistica.domain.services.MarcaService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControlViewCadastrarCompra implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void salvar(){
        Compra compra = new Compra();
        compra.setDataCompra(null);
        CompraService.cadastrarCompra(compra);
    }

}
