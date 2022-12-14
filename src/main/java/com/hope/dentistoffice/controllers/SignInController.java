package com.hope.dentistoffice.controllers;

import com.hope.dentistoffice.models.domainmodels.LoginInfo;
import com.hope.dentistoffice.models.userinterfacemodels.SignInModel;
import com.hope.dentistoffice.persistence.database.dao.LoginDaoFactory;
import com.hope.dentistoffice.utilities.GuiHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.hope.dentistoffice.utilities.GuiHelper.showDialog;

public class SignInController implements Initializable {
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    private SignInModel signInModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signInModel = new SignInModel(new LoginDaoFactory());
    }

    @FXML
    public void onLoginBtnClick(ActionEvent actionEvent) {
        sendInput();
        validateAndProceed(actionEvent);
    }

    private void sendInput() {
        LoginInfo loginInfo = createLoginInfoInstance();
        signInModel.receiveInput(loginInfo);
    }

    private void validateAndProceed(ActionEvent actionEvent) {
        int validationResult = signInModel.isValidLogin();
        switch (validationResult) {
            case 0 -> showDialog(Alert.AlertType.ERROR,
                    "invalid inputs",
                    "Username and password must be at least 6 length each",
                    "Please fill all the information");

            case 1 -> showDialog(Alert.AlertType.WARNING,
                    "wrong inputs",
                    "Invalid username or password",
                    "Please make sure you entered the correct username and password");

            case 2 -> GuiHelper.showMainView(actionEvent);
        }
    }

    private LoginInfo createLoginInfoInstance() {
        return LoginInfo.getBuilder().
                withUserName(userNameField.getText()).
                withPassword(passwordField.getText()).
                build();
    }
}
