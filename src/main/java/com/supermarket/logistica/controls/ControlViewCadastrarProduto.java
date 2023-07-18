package com.supermarket.logistica.controls;

import com.supermarket.logistica.domain.models.Categoria;
import com.supermarket.logistica.domain.models.Marca;
import com.supermarket.logistica.domain.models.Produto;
import com.supermarket.logistica.domain.services.CategoriaService;
import com.supermarket.logistica.domain.services.MarcaService;
import com.supermarket.logistica.domain.services.ProdutoService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControlViewCadastrarProduto implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listarCategorias();
        listarMarcas();

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
        Produto produto = new Produto();
        produto.setDescricao(tfDescricao.getText());
        produto.setCusto(Double.parseDouble(tfCusto.getText()));
        produto.setCodigoBarras(tfCodigoBarras.getText());
        produto.setPontoReposicao(Integer.parseInt(tfPontoReposicao.getText()));

        Categoria categoria = new Categoria();
        categoria.setId(1L);


        produto.getCategorias().add(categoria);
        produto.setMarca(cmbMarca.getSelectionModel().getSelectedItem());
        ProdutoService.cadastrarProduto(produto);
        btnSalvar.getScene().getWindow().hide();
    }

    private void listarCategorias(){
        cmbCategoria.setItems(FXCollections.observableList(CategoriaService.listarCategorias()));
    }

    private void listarMarcas(){
        cmbMarca.setItems(FXCollections.observableList(MarcaService.listarMarcas()));
    }

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfCusto;

    @FXML
    private TextField tfCodigoBarras;

    @FXML
    private TextField tfPontoReposicao;

    @FXML
    private ComboBox<Categoria> cmbCategoria;

    @FXML
    private ComboBox<Marca> cmbMarca;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnCancelar;


}
