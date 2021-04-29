package com.home.pocker_stars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(Pattern.matches("(uplink)\\d{1,2}", "uplink0"));
    }
}
