package com.fiko942.moduatasksatu;

import java.lang.reflect.Method;

public class Main {

    /**
     * jalankan banyak test untuk setiap method
     * 
     * @param args argumen yang ditangkap oleh program
     */
    public static void main(String[] args) {
        Validator validator = new Validator();

        // Test email validation
        testValidation(validator, "test@example.com", "isEmail", false);
        testValidation(validator, "notanemail", "isEmail", false);
        // Test url validation
        testValidation(validator, "https://example.com", "isUrl", false);
        testValidation(validator, "invalid-url", "isUrl", false);
        // Test alpha validation
        testValidation(validator, "abc", "isAlpha", false);
        testValidation(validator, "abc123", "isAlpha", false);
        // Test numeric validation
        testValidation(validator, "123", "isNumeric", false);
        testValidation(validator, "abc123", "isNumeric", false);
        // Test alphanumeric validation
        testValidation(validator, "abc123", "isAlphanumeric", false);
        testValidation(validator, "abc@123", "isAlphanumeric", false);
        // Test port validation
        testValidation(validator, "8080", "isPort", false);
        testValidation(validator, "99999", "isPort", false);
        // Test IP validation
        testValidation(validator, "192.168.0.1", "isIP", false);
        testValidation(validator, "999.999.999.999", "isIP", false);
        // Test slug validation
        testValidation(validator, "valid-slug", "isSlug", false);
        testValidation(validator, "Invalid Slug", "isSlug", false);
    }

    private static void testValidation(Validator validator, String input, String method, boolean expectedResult) {
        try {
            Method methodObject = Validator.class.getMethod(method, String.class);
            boolean result = (boolean) methodObject.invoke(validator, input);
            System.out.println(method + (result == expectedResult ? ": PASS" : ": FAIL") + " - ("+ input +")");
        } catch (Exception e) {
            System.out.println(method + ": FAIL (Exception) - (" + input + ")");
        }
    }
}
