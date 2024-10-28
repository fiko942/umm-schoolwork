package com.fiko942.moduatasksatu;

import java.util.regex.Pattern;

public class Validator {

    public boolean isEmail(String input) {
        String pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(pattern, input);
    }

    public boolean isUrl(String input) {
        String urlPattern = "^(https?|ftp)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]+[-a-zA-Z0-9+&@#/%=~_|]";
        return Pattern.matches(urlPattern, input);
    }

    public boolean isAlpha(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public boolean isNumeric(String input) {
        return input.matches("[0-9]+");
    }

    public boolean isAlphanumeric(String input) {
        return input.matches("[a-zA-Z0-9]+");
    }

    public boolean isPort(String input) {
        if (!isNumeric(input)) {
            return false;
        }
        int port = Integer.parseInt(input);
        return port >= 0 && port <= 65535;
    }

    public boolean isIP(String input) {
        String ipPattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return Pattern.matches(ipPattern, input);
    }

    public boolean isSlug(String input) {
        String slugPattern = "^[a-z0-9]+(?:-[a-z0-9]+)*$";
        return Pattern.matches(slugPattern, input);
    }
}
