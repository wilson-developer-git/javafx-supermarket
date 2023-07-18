package com.supermarket.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class FormUtil {
    public static FXMLLoader exibirFormCadastro(String url, String titulo, Window window) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FormUtil.class.getResource(url));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.initOwner(window);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initStyle(StageStyle.UTILITY);
            stage.setScene(scene);
            stage.toFront();
            stage.showAndWait();
            return fxmlLoader;
    }
}
