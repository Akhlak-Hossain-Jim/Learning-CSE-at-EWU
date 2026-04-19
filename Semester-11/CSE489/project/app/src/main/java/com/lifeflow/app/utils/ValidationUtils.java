package com.lifeflow.app.utils;

import android.util.Patterns;

/**
 * Reusable form-validation helpers used across all form screens.
 */
public final class ValidationUtils {

    private ValidationUtils() {}

    /** Returns true if the string is non-null and non-empty after trimming. */
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    /** Returns true if the string matches a standard email pattern. */
    public static boolean isValidEmail(String email) {
        return isNotEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
    }

    /**
     * Returns true if the phone number is non-empty and contains only digits,
     * spaces, hyphens, or a leading '+'. Minimum 7 digits required.
     */
    public static boolean isValidPhone(String phone) {
        if (!isNotEmpty(phone)) return false;
        String stripped = phone.trim().replaceAll("[\\s\\-]", "");
        if (stripped.startsWith("+")) stripped = stripped.substring(1);
        return stripped.matches("\\d{7,15}");
    }

    /** Returns true if the password is at least 6 characters. */
    public static boolean isPasswordStrong(String password) {
        return password != null && password.length() >= 6;
    }
}
