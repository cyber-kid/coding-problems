package com.home.task_017_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solve(String s, String t) {
        Map<Character, Integer> given = new HashMap<>();
        Map<Character, Integer> found = new HashMap<>();

        for (Character character : t.toCharArray()) {
            given.merge(character, 1, Integer::sum);
        }

        int totalFound = 0;
        int leftIndex = 0;
        String result = "";

        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            char rightItem = s.charAt(rightIndex);

            if (given.containsKey(rightItem)) {
                int count = found.merge(rightItem, 1, Integer::sum);

                if (count <= given.get(rightItem)) {
                    totalFound++;
                }
            }

            while (totalFound == t.length()) {
                String interimResult = s.substring(leftIndex, rightIndex + 1);
                if (result.isEmpty()) {
                    result = interimResult;
                } else if (interimResult.length() < result.length()) {
                    result = interimResult;
                }

                char leftItem = s.charAt(leftIndex);

                if (given.containsKey(leftItem)) {
                    int count = found.merge(leftItem, 1, (oldValue, newValue) -> oldValue - newValue);
                    if (count < given.get(leftItem)) {
                        totalFound--;
                    }
                }

                leftIndex++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.printf("A: %s, E: %s\n", solution.solve("ADOBECODEBANC", "ABC"), "BANC");
        System.out.printf("A: %s, E: %s\n", solution.solve("a", "a"), "a");
        System.out.printf("A: %s, E: %s\n", solution.solve("a", "aa"), "a");
        System.out.printf("A: %s, E: %s\n", solution.solve("aa", "aa"), "aa");
    }
}
