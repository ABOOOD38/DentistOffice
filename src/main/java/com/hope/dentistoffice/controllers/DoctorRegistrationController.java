package com.hope.dentistoffice.controllers;

import com.hope.dentistoffice.models.domainmodels.Doctor;
import com.hope.dentistoffice.models.domainmodels.LoginInfo;
import com.hope.dentistoffice.models.domainmodels.PersonalInfo;
import com.hope.dentistoffice.models.userinterfacemodels.DoctorRegistrationModel;
import com.hope.dentistoffice.utilities.Constants;
import com.hope.dentistoffice.utilities.GuiHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorRegistrationController implements Initializable {
    @FXML
    private TextField fNameField, lNameField, emailField, phoneNumberField, userNameField;
    @FXML
    private PasswordField passwordField;

    private DoctorRegistrationModel doctorRegistrationModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.doctorRegistrationModel = new DoctorRegistrationModel();
    }

    @FXML
    private void onCLickRegisterBtn(ActionEvent actionEvent) {
        sendInput();
        validateAndProceed(actionEvent);
    }

    @FXML
    private void onClickBackBtn(ActionEvent actionEvent) {
        showMainScreen(actionEvent);
    }

    @FXML
    private void onClickClearBtn(ActionEvent actionEvent) {
        resetFieldsText();
    }

    private void validateAndProceed(ActionEvent actionEvent) {
        int validDoctorRes = doctorRegistrationModel.isValidDoctor();
        switch (validDoctorRes) {
            case 0 -> {
                GuiHelper.showDialog(Alert.AlertType.CONFIRMATION, "Registration", "Registration completed", "The doctor registered successfully");
                GuiHelper.showMainView(actionEvent);
            }
            case 1 ->
                    GuiHelper.showInvalidInputDialog("Invalid First or Last name", "Each of First name and Last name must be between (3 and 20) length");
            case 2 ->
                    GuiHelper.showInvalidInputDialog("Invalid Email address", "Email address must be correctly formatted ex: Abood@gmail.com");
            case 3 ->
                    GuiHelper.showInvalidInputDialog("Invalid phone number", "Phone number must start with 962 and 12 length long");
            case 4 ->
                    GuiHelper.showInvalidInputDialog("Invalid User name or password", "Each of User name and password must be between (6 and 20) length");
        }

    }

    private void sendInput() {
        Doctor doctor = getDoctorInstance();
        doctorRegistrationModel.receiveInput(doctor);
    }

    private Doctor getDoctorInstance() {
        PersonalInfo personalInfo = createPersonalInfoInstance();
        LoginInfo loginInfo = createLoginInfoInstance();

        return Doctor.getBuilder().
                withLoginInfo(loginInfo).
                withPersonalInfo(personalInfo).
                build();
    }

    private PersonalInfo createPersonalInfoInstance() {
        return PersonalInfo.getBuilder().
                withName(fNameField.getText() + " " + lNameField.getText()).
                withEmail(emailField.getText()).
                withPhoneNumber(phoneNumberField.getText()).
                build();
    }

    private LoginInfo createLoginInfoInstance() {
        return LoginInfo.getBuilder().
                withUserName(userNameField.getText()).
                withPassword(passwordField.getText()).
                build();
    }

    private void showMainScreen(ActionEvent event) {
        try {
            GuiHelper.changeScene(event, Constants.MAIN_VIEW);
        } catch (IOException e) {
            System.err.println("Error in showMainScreen() \n" + e.getMessage());
        }
    }

    private void resetFieldsText() {
        fNameField.setText("");
        lNameField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        userNameField.setText("");
        passwordField.setText("");
    }


}
