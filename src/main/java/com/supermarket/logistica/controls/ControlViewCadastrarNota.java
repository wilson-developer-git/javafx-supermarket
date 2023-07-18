package com.supermarket.logistica.controls;

import com.supermarket.logistica.domain.models.Nota;
import com.supermarket.logistica.domain.models.enums.TipoNota;
import com.supermarket.logistica.domain.services.NotaService;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlViewCadastrarNota implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cmbTipoNota.setItems(FXCollections.observableArrayList(TipoNota.values()));

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
        Nota nota = new Nota();
        nota.setTipoNota(cmbTipoNota.getSelectionModel().getSelectedItem());
        nota.setNumero(tfNumero.getText());
        nota.setTotal(Double.parseDouble(tfTotal.getText()));
        NotaService.cadastrarNotaService(nota);
        btnSalvar.getScene().getWindow().hide();
    }

    @FXML
    private ComboBox<TipoNota> cmbTipoNota;

    @FXML
    private TextField tfNumero;

    @FXML
    private DatePicker dpDataCompra;

    @FXML
    private TextField tfTotal;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnCancelar;



}
