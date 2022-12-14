package com.hope.dentistoffice.models.userinterfacemodels;

import com.hope.dentistoffice.models.domainmodels.Doctor;
import com.hope.dentistoffice.utilities.Validation;

public class DoctorRegistrationModel {
    private Doctor doctor;

    public void receiveInput(Doctor doctor) {
        this.doctor = doctor;
    }


    //1 Not valid First and last name
    //2 not valid email address
    //3 not valid phone number
    //4 not valid username or password
    public int isValidDoctor() {
        if (!Validation.isValidName(doctor.personalInfo().name()))
            return 1;

        if (!Validation.isValidEmailAddress(doctor.personalInfo().email()))
            return 2;

        if (!Validation.isValidPhoneNumber(doctor.personalInfo().phoneNumber()))
            return 3;

        if (!Validation.isValidLoginInfo(doctor.loginInfo()))
            return 4;

        return 0;
    }


}
