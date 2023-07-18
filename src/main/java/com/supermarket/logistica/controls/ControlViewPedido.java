package com.supermarket.logistica.controls;

import com.supermarket.logistica.domain.models.*;
import com.supermarket.logistica.domain.models.enums.StatusPedido;
import com.supermarket.logistica.domain.services.ProdutoService;
import com.supermarket.logistica.domain.services.UnidadeMedidaService;
import com.supermarket.util.MaskFieldUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControlViewPedido implements Initializable {

    private ObservableList<Produto> itensProduto;
    private ObservableList<ItemProdutoRelatorioPedido> itensPedido;
    private Pedido pedido;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        inicializarTabelaProdutos();
        inicializarTabelaItensPedido();
        iniciarPedido();

        adicionarItemPedidoComMouse();
        adicionarItemPedidoComEnter();

        removerItemPedidoComMouse();
        removerItemPedidoComEnter();

        formatarCampoNumericoQuantidade();
        inicializarCampoUnidadeMedida();

        btnGeararPlanilha.setOnMouseClicked(e->{
            exportarExcel();
        });

    }

    private void formatarCampoNumericoQuantidade() {
        tfQtdItemPedido.setText("1");
        MaskFieldUtil.numericField(tfQtdItemPedido);
        MaskFieldUtil.maxField(tfQtdItemPedido, 3);
    }

    private void iniciarPedido() {
        pedido = new Pedido();
        pedido.setPeriodo(LocalDate.now());
        pedido.setItensPedido(itensPedido);
        pedido.setStatusPedido(StatusPedido.ABERTO);
    }

    private void inicializarCampoUnidadeMedida() {
        cmbUnidadeMedida.getItems().addAll(FXCollections.observableList(UnidadeMedidaService.listarUnidadesMedida()));
    }

    private void inicializarTabelaProdutos() {
        itensProduto = FXCollections.observableList(ProdutoService.listarProdutos());
        tblProdutos.setItems(itensProduto);
        colIDProduto.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDescricaoProduto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        ;
        colPontoReposicaoProduto.setCellValueFactory(new PropertyValueFactory<>("pontoReposicao"));
        ;
        colQtdProduto.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        ;
    }

    private void inicializarTabelaItensPedido() {
        itensPedido = FXCollections.observableArrayList();
        tblItensPedido.setItems(itensPedido);
        colIDItemPedido.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
        colDescricaoItemProduto.setCellValueFactory(new PropertyValueFactory<>("descricaoProduto"));
        colQtdItemPedido.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colUnidadeMedidaProduto.setCellValueFactory(new PropertyValueFactory<>("descricaoUnidadeMedida"));
    }

    private void adicionarItemPedido() {
        if (validarDados()) {
            Produto produto = tblProdutos.getSelectionModel().getSelectedItem();
            UnidadeMedida unidadeMedida = cmbUnidadeMedida.getSelectionModel().getSelectedItem();
            int quantidade = Integer.parseInt(tfQtdItemPedido.getText());
            itensPedido.add(
                    new ItemProdutoRelatorioPedido(pedido, produto, quantidade, unidadeMedida));
            tblItensPedido.refresh();
            tblProdutos.getSelectionModel().clearSelection();
            cmbUnidadeMedida.getSelectionModel().clearSelection(0);
        }
    }

    private void adicionarItemPedidoComMouse() {
        btnAdicionarProduto.setOnMouseClicked(KeyEvent -> {
            if (KeyEvent.getButton().name().equals("PRIMARY")) {
                adicionarItemPedido();
            }
        });
    }

    private void adicionarItemPedidoComEnter() {
        btnAdicionarProduto.setOnKeyPressed(KeyEvent -> {
            if (KeyEvent.getCode() == KeyCode.ENTER) {
                adicionarItemPedido();
            }
        });
    }

    private void removerItemPedido() {
        ItemProdutoRelatorioPedido itemPedido = tblItensPedido.getSelectionModel().getSelectedItem();
        if (itemPedido != null) {
            itensPedido.remove(itemPedido);
            tblItensPedido.refresh();
            tblItensPedido.getSelectionModel().clearSelection();
        } else {
            System.out.println("Selecione um item de pedido.");
        }

    }

    private void removerItemPedidoComMouse() {
        btnRemoverProduto.setOnMouseClicked(KeyEvent -> {
            if (KeyEvent.getButton().name().equals("PRIMARY")) {
                removerItemPedido();
            }
        });
    }

    private void removerItemPedidoComEnter() {
        btnRemoverProduto.setOnKeyPressed(KeyEvent -> {
            if (KeyEvent.getCode() == KeyCode.ENTER) {
                removerItemPedido();
            }
        });
    }

    /** EXPORTAR LISTA PARA EXCEL */
    private void exportarExcel(){
        try{

            Locale ptBR = new Locale("pt", "BR");

            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet =  workbook.createSheet("FirstSheet");

            // criando as linhas
            HSSFRow rowhead=   sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("ID");
            rowhead.createCell(1).setCellValue("DESCRIÇÃO");

            // definindo seus valores
            short i = 1;
            for (ItemProdutoRelatorioPedido p: tblItensPedido.getItems())
            {
                    HSSFRow row = sheet.createRow(i);
                    row.createCell(0).setCellValue(p.getIdProduto());
                    row.createCell(1).setCellValue(p.getDescricaoProduto());
                    i++;

            }

            /** LOCAL DESTINO ARQUIVO */
            String filename="C:/Users/Wilson/Desktop/planilha.xls" ;

            FileOutputStream fileOut =  new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();

            //MensagemUtil.mensagemSucesso("Lista criada com sucesso!","","");
        } catch ( Exception ex ) {
            System.out.println(ex);

        }
    }

    private boolean validarDados(){
        if (tblProdutos.getSelectionModel().getSelectedItem() == null){
            System.out.println("Selecione um produto na lista");
            return false;
        }
        if (cmbUnidadeMedida.getSelectionModel().getSelectedItem() == null){
            System.out.println("Selecione uma unidade de medida");
            return false;
        }
        if (tfQtdItemPedido.getText().equals("")){
            System.out.println("Quantidade não é valida");
            return false;
        }
        if (Integer.parseInt(tfQtdItemPedido.getText()) <= 0){
            System.out.println("Quantidade não é valida");
            return false;
        }
        return true;
    }

    @FXML
    private ComboBox<UnidadeMedida> cmbUnidadeMedida;
    @FXML
    private TextField tfQtdItemPedido;
    @FXML
    private TableView<Produto> tblProdutos;
    @FXML
    private TableColumn<Produto, ?> colIDProduto;
    @FXML
    private TableColumn<Produto, ?> colDescricaoProduto;
    @FXML
    private TableColumn<Produto, ?> colPontoReposicaoProduto;
    @FXML
    private TableColumn<Produto, ?> colQtdProduto;
    @FXML
    private TableView<ItemProdutoRelatorioPedido> tblItensPedido;
    @FXML
    private TableColumn<ItemProdutoRelatorioPedido, ?> colIDItemPedido;
    @FXML
    private TableColumn<ItemProdutoRelatorioPedido, ?> colDescricaoItemProduto;
    @FXML
    private TableColumn<ItemProdutoRelatorioPedido, ?> colQtdItemPedido;
    @FXML
    private TableColumn<ItemProdutoRelatorioPedido, ?> colUnidadeMedidaProduto;
    @FXML
    private Button btnAdicionarProduto;
    @FXML
    private Button btnRemoverProduto;
    @FXML
    private Button btnGeararPlanilha;
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnConcluirPedido;
}
