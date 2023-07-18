package com.supermarket.comercial.controls;

import com.supermarket.comercial.domain.dto.CaixaDTO;
import com.supermarket.comercial.domain.service.CaixaService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlViewNovoCaixa implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnAbrirNovoCaixa.setOnMouseClicked(e->{abrirNovoCaixa();});
    }

   private void abrirNovoCaixa(){
        String fundoTroco =  tfFundoTroco.getText();
        CaixaDTO caixaDTO = new CaixaDTO();
        caixaDTO.setFundoDeTroco(Double.parseDouble(fundoTroco));
        CaixaService caixaService = new CaixaService();
        caixaService.abrirNovoCaixa(caixaDTO);
    }


    @FXML
    private TextField tfFundoTroco;
    @FXML
    private Button btnAbrirNovoCaixa;

}
