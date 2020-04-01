package com.home.timeconversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion {
    public static void main(String[] args) {
        String input = "12:40:22PM";

        String result = convertTime(input);

        System.out.println("Result is: " + result);
    }

    private static String convertTime(String input) {
        String pattern = "^(\\d{2}):(\\d{2}):(\\d{2})(AM|PM)$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(input);

        if (m.find()) {
            int hours24style = Integer.valueOf(m.group(1)) + 12;
            if (m.group(4).equalsIgnoreCase("PM")) {
                if (hours24style == 24) {
                    return m.replaceFirst("12:$2:$3");
                } else {
                    return m.replaceFirst(hours24style + ":$2:$3");
                }
            } else {
                if (hours24style == 24) {
                    return m.replaceFirst("00:$2:$3");
                } else {
                    return m.replaceFirst("$1:$2:$3");
                }
            }
        } else {
            throw new IllegalArgumentException(
                    "Wrong time format. Example: 07:05:45AM or 07:05:45PM");
        }
    }
}
