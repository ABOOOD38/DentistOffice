package com.hope.dentistoffice.models.userinterfacemodels;

import com.hope.dentistoffice.models.domainmodels.LoginInfo;
import com.hope.dentistoffice.persistence.database.dao.IDao;
import com.hope.dentistoffice.persistence.database.dao.IDaoFactory;
import com.hope.dentistoffice.utilities.Auth;
import com.hope.dentistoffice.utilities.Validation;

import java.sql.SQLException;
import java.util.Collection;

public class SignInModel {
    private final IDao<LoginInfo> loginDao;
    private Collection<LoginInfo> loginInfos;
    private LoginInfo loginInfo;

    public SignInModel(final IDaoFactory<LoginInfo> daoFactory) {
        this.loginDao = daoFactory.createDao();
        loadLoginInfoObjects();
    }

    private void loadLoginInfoObjects() {
        try {
            this.loginInfos = loginDao.getAll();
        } catch (SQLException e) {
            System.err.println("Error in loadLoginInfoObjects()\n " + e.getMessage());
        }
    }

    public void receiveInput(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }


    //0 means empty username or password, 1 means not valid login ,2 means valid login
    public int isValidLogin() {
        if (Validation.isValidLoginInfo(loginInfo))
            return 0;

        if (!Auth.isValidLogin(loginInfo, loginInfos))
            return 1;
        return 2;
    }
}
