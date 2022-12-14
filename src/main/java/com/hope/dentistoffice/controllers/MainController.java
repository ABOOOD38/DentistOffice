package com.hope.dentistoffice.controllers;

import com.hope.dentistoffice.utilities.GuiHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.IOException;

import static com.hope.dentistoffice.utilities.Constants.ADD_DOCTOR_VIEW;

public class MainController {
    @FXML
    private Button addDoctorBtn;
    @FXML
    private Button addPatientBtn;

    @FXML
    public void onCLickAddDoctorBtn(ActionEvent actionEvent) {
        showAddDoctorView(actionEvent);
    }

    @FXML
    public void onClickAddPatientBtn(ActionEvent actionEvent) {
        GuiHelper.showDialog(Alert.AlertType.CONFIRMATION, "s", "aa", "ss");

    }

    private void showAddDoctorView(ActionEvent actionEvent) {
        try {
            GuiHelper.changeScene(actionEvent, ADD_DOCTOR_VIEW);
        } catch (IOException e) {
            System.err.println("Error in showAddDoctorView() \n" + e.getMessage());
        }
    }

}
