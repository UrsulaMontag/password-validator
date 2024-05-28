package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void isAtLeast8Chars_returnsFalse_whenPasswordTooShort() {
        boolean result = Main.isAtLeast8Chars("123");
        assertFalse(result);
    }

    @Test
    void isAtLeast8Chars_returnsTrue_whenPasswordLongEnough() {
        boolean result = Main.isAtLeast8Chars("1234567891011");
        assertTrue(result);
    }

    @Test
    void isAtLeast8Chars_returnsTrue_whenPasswordHas8Chars() {
        boolean result = Main.isAtLeast8Chars("12345678");
        assertTrue(result);
    }

    @Test
    void containsDigits_returnsFalse_whenPasswordNotContainDigits() {
        boolean result = Main.containsDigits("abcdefghijk");
        assertFalse(result);
    }

    @Test
    void containsDigits_returnsFalse_whenPasswordNotContainDigitsButSpecialCharacter() {
        boolean result = Main.containsDigits("a$bc_def/");
        assertFalse(result);
    }

    @Test
    void containsDigits_returnsTrue_whenPasswordContainDigit() {
        boolean result = Main.containsDigits("abcd1fgh5");
        assertTrue(result);
    }

    @Test
    void containsLowerAndUppercase_returnsFalse_whenPasswordNotContainUppercase() {
        boolean result = Main.containsLowerAndUppercase("abcdefghijk");
        assertFalse(result);
    }

    @Test
    void containsLowerAndUppercase_returnsFalse_whenPasswordNotContainLowercase() {
        boolean result = Main.containsLowerAndUppercase("ABCDEFGHIJK");
        assertFalse(result);
    }

    @Test
    void containsLowerAndUppercase_returnsTrue_whenPasswordContainLowerAnd_Uppercase() {
        boolean result = Main.containsLowerAndUppercase("abcDefGHijk");
        assertTrue(result);
    }

    @Test
    void isPasswordCommonlyInUse_returnsFalse_whenPasswordIsCommonlyInUse() {
        String[] passwordsToCheck = {"Password1", "Aa345678", "Password3", "Password4"};
        boolean result = Main.isPasswordCommonlyInUse("Password1", passwordsToCheck);
        assertFalse(result);
    }

    @Test
    void isPasswordCommonlyInUse_returnsFalse_whenPasswordIsTooSimilarToCommonPassword() {
        String[] passwordsToCheck = {"Password1", "Aa345678", "Password3", "Password4"};
        boolean result = Main.isPasswordCommonlyInUse("passWord1", passwordsToCheck);
        assertFalse(result);
    }

    @Test
    void isPasswordCommonlyInUse_returnsTrue_whenPasswordIsActuallySave() {
        String[] passwordsToCheck = {"Password1", "Aa345678", "Password3", "Password4"};
        boolean result = Main.isPasswordCommonlyInUse("P20wd24!", passwordsToCheck);
        assertTrue(result);
    }
}