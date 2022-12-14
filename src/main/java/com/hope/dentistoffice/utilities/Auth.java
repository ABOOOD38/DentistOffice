package com.hope.dentistoffice.utilities;

import com.hope.dentistoffice.models.domainmodels.LoginInfo;

import java.util.Collection;

public class Auth {

    public static boolean isValidLogin(LoginInfo loginInfo, Collection<LoginInfo> loginInfos) {
        return loginInfos.stream().anyMatch(x -> x.equals(loginInfo));
    }


}
