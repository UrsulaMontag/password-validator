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
//
//    public static boolean isCommonlyInUsed(String password) {}
}