package com.supermarket.logistica.controls;

import com.supermarket.logistica.domain.models.PrecoVendaProduto;
import com.supermarket.logistica.domain.models.Produto;
import com.supermarket.logistica.domain.models.UnidadeMedida;
import com.supermarket.logistica.domain.services.CategoriaService;
import com.supermarket.logistica.domain.services.PrecoVendaProdutoService;
import com.supermarket.logistica.domain.services.ProdutoService;
import com.supermarket.logistica.domain.services.UnidadeMedidaService;
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

public class ControlViewCadastrarPrecoVendaProduto implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        listarUnidadesMedida();

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

    public void setProduto(Produto prod){
        this.produto = prod;
        tfProduto.setText(produto.getDescricao());
    }

    private void salvar(){
        PrecoVendaProduto precoVendaProduto = new PrecoVendaProduto();
        precoVendaProduto.setProduto(produto);
        precoVendaProduto.setPreco(Double.parseDouble(tfPreco.getText()));
        precoVendaProduto.setUnidadeMedida(cmbUnidadeMedida.getSelectionModel().getSelectedItem());
        PrecoVendaProdutoService.cadastrarPrecoVendaProduto(precoVendaProduto);
        btnSalvar.getScene().getWindow().hide();
    }

    private void listarUnidadesMedida(){
        cmbUnidadeMedida.setItems(FXCollections.observableList(UnidadeMedidaService.listarUnidadesMedida()));
    }

    Produto produto = null;

    @FXML
    private TextField tfProduto;

    @FXML
    private TextField tfPreco;

    @FXML
    private ComboBox<UnidadeMedida> cmbUnidadeMedida;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnCancelar;


}
