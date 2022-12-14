package com.hope.dentistoffice.utilities;

import com.hope.dentistoffice.DentistOfficeApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

//Contains Gui helper methods
public class GuiHelper {
    public static void changeScene(ActionEvent event, String view) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(DentistOfficeApplication.class.getResource(view)));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void showDialog(Alert.AlertType alertType, String titleMsg, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titleMsg);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static void showInvalidInputDialog(String headerText, String contentText) {
        showDialog(Alert.AlertType.ERROR, "Invalid Input", headerText, contentText);
    }

    public static void showMainView(ActionEvent actionEvent) {
        try {
            changeScene(actionEvent, Constants.MAIN_VIEW);
        } catch (IOException e) {
            System.err.println("Error in showMainView() \n" + e.getMessage());
        }
    }


}
