package com.example.ambulancesystem;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class check_email {
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9.]+$";

    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static boolean isEmailValid(String email, String email1) {
        if (email.equals(email1)) {
            return true;
        }
        return false;
    }

}
