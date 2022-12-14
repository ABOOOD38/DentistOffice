package com.hope.dentistoffice.controllers;

import com.hope.dentistoffice.utilities.Constants;
import com.hope.dentistoffice.utilities.GuiHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class IndexController {
    @FXML
    private Label welcomeLabel;
    @FXML
    private Button singInBtn;

    @FXML
    private void onSignInBtnClick(ActionEvent actionEvent) {
        showSignInView(actionEvent);
    }

    private void showSignInView(ActionEvent actionEvent) {
        try {
            GuiHelper.changeScene(actionEvent, Constants.SIGNIN_VIEW);
        } catch (IOException e) {
            System.err.println("Error in onSignInBtnClick() \n" + e.getMessage());
        }
    }
}