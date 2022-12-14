package com.hope.dentistoffice.utilities;

import com.hope.dentistoffice.models.domainmodels.LoginInfo;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static boolean isEmptyLoginInfo(@NotNull LoginInfo loginInfo) {
        return loginInfo.userName().isEmpty() || loginInfo.password().isEmpty();
    }

    public static boolean isValidLoginInfo(LoginInfo loginInfo) {
        if (isEmptyLoginInfo(loginInfo))
            return false;

        String userName = loginInfo.userName();
        String password = loginInfo.password();
        return userName.length() >= 6 &&
                password.length() >= 6 &&
                userName.length() <= 20 &&
                password.length() <= 20;

    }

    public static boolean isValidPhoneNumber(@NotNull String number) {
        return number.length() == 12 &&
                number.chars().allMatch(Character::isDigit) &&
                number.startsWith("962");
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return email.equals("No Email") || m.matches();
    }

    public static boolean isValidName(String name) {
        if (isEmptyName(name)) {
            return false;
        }

        String[] nameParts = getFirstAndLastName(name);
        String fName = nameParts[0];
        String lName = nameParts[1];
        String fullName = nameParts[0] + nameParts[1];

        return fullName.chars().allMatch(Character::isAlphabetic) &&
                fName.length() >= 3 &&
                fName.length() <= 20 &&
                lName.length() >= 3 &&
                lName.length() <= 20;
    }

    private static boolean isEmptyName(String name) {
        return getFirstAndLastName(name).length < 2;
    }

    private static String[] getFirstAndLastName(@NotNull String name) {
        return name.split(" ");
    }


}
