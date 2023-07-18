package com.supermarket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(App.class.getResource(
                "/com/supermarket/views/logistica/ViewCadastrarNota.fxml"));
        Parent layout = loader.load();
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}