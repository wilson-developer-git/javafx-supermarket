package com.supermarket.logistica.controls;

import com.supermarket.logistica.domain.models.Categoria;
import com.supermarket.logistica.domain.services.CategoriaService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlViewCadastrarCategoria implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnSalvar.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    salvar();
                }
            }
        });

        btnSalvar.setOnMouseClicked(e->{
            salvar();
        });

    }

    private void salvar(){
        Categoria categoria = new Categoria();
        categoria.setDescricao(tfDescricao.getText());
        CategoriaService.cadastrarCategoria(categoria);
        btnSalvar.getScene().getWindow().hide();
    }



    @FXML
    private TextField tfDescricao;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnCancelar;


}
