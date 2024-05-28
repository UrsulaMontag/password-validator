package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    String[] passwordsToCheck = {"Password1", "Aa345678", "Password123", "1234Password", "Master123"};
    String[] testPasswords = {"P20wd24!", "Ade34_78!", "g00d_Pa55W0rd!"};

    @Test
    void isAtLeast8Chars_returnsFalse_whenPasswordTooShort() {
        boolean result = Main.isAtLeast8Chars("123");
        assertFalse(result);
    }

    @Test
    void isAtLeast8Chars_returnsTrue_whenPasswordLongEnough() {
        for (String password : testPasswords) {
            assertTrue(Main.isAtLeast8Chars(password));
        }
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
        for (String password : testPasswords) {
            assertTrue(Main.containsDigits(password));
        }
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
        for (String password : testPasswords) {
            assertTrue(Main.containsLowerAndUppercase(password));
        }
    }

    @Test
    void containsSpecialCharacters_returnsTrue_whenPasswordContainsSpecialCharacters() {
        assertFalse(Main.containsSpecialCharacters("abcdefhi25~k"));
        for (String password : testPasswords) {
            assertTrue(Main.containsSpecialCharacters(password));
        }
    }

    @Test
    void isNotCommonlyInUse_returnsFalse_whenPasswordIsCommonlyInUse() {
        boolean result = Main.isNotCommonlyInUse("Password1", passwordsToCheck);
        assertFalse(result);
    }

    @Test
    void isNotCommonlyInUse_returnsFalse_whenPasswordIsSimilarToCommonPassword() {
        boolean result = Main.isNotCommonlyInUse("passWord1", passwordsToCheck);
        assertFalse(result);
    }

    @Test
    void isNotCommonlyInUse_returnsFalse_whenPasswordIsJustDiffInDigitsToCommonPassword() {
        boolean result = Main.isNotCommonlyInUse("pass237483Word4567", passwordsToCheck);
        assertFalse(result);
    }

    @Test
    void isNotCommonlyInUse_returnsTrue_whenPasswordIsActuallySave() {
        for (String password : testPasswords) {
            assertTrue(Main.isNotCommonlyInUse(password, passwordsToCheck));
        }
    }
}