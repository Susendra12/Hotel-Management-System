package com.example.SpringSecurity_Register_Login.entity;

public class CodeGeneratorUtil {

    public static String getNextCode(String current) {
        char[] chars = current.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];

            if (Character.isDigit(ch)) {
                if (ch < '9') {
                    chars[i]++;
                    break;
                } else {
                    chars[i] = '0';
                }
            } else if (Character.isUpperCase(ch)) {
                if (ch < 'Z') {
                    chars[i]++;
                    break;
                } else {
                    chars[i] = 'A';
                }
            }
        }

        String next = new String(chars);

        if (current.equals("9999999")) {
            return "A000001";
        }

        if (next.equals("0000000")) {
            return "0000001";
        }

        return next;
    }
}
