package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static boolean isAtLeast8Chars(String password) {
        return password.length() >= 8;
    }

    public static boolean containsDigits(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean containsLowerAndUppercase(String password) {
        return (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*"));
    }

    public static boolean isNotCommonlyInUse(String password, String[] commonPasswords) {
        boolean result = true;
        for (String commonPassword : commonPasswords) {
            if ((commonPassword.replaceAll("[0-9]", "")).equalsIgnoreCase(password.replaceAll("[0-9]", ""))) {
                result = false;
                break;
            }
        }
        return result;
    }
}