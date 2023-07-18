package com.supermarket.logistica.controls;

import com.supermarket.logistica.domain.models.Localizacao;
import com.supermarket.logistica.domain.models.enums.Departamento;
import com.supermarket.logistica.domain.services.LocalizacaoService;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class ControlViewCadastrarLocalizacao implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listarDepartamentos();

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
        Localizacao localizacao = new Localizacao();
        localizacao.setDescricao(tfDescricao.getText());
        localizacao.setDepartamento(cmbDepartamento.getSelectionModel().getSelectedItem());
        LocalizacaoService.cadastrarLocalizacao(localizacao);
        btnSalvar.getScene().getWindow().hide();
    }

    private void listarDepartamentos(){
        cmbDepartamento.setItems(FXCollections.observableArrayList(Departamento.values()));
    }

    @FXML
    private TextField tfDescricao;

    @FXML
    private ComboBox<Departamento> cmbDepartamento;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnCancelar;


}
