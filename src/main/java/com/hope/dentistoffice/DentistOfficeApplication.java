package com.hope.dentistoffice;

import com.hope.dentistoffice.utilities.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DentistOfficeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DentistOfficeApplication.class.getResource(Constants.INDEX_VIEW));
        Scene scene = new Scene(fxmlLoader.load(), 250, 200);
        stage.setTitle("Dentist Office");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}