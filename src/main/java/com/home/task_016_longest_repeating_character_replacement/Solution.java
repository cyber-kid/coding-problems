package com.home.task_016_longest_repeating_character_replacement;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> occurrencesCount = new HashMap<>();

        int leftIndex = 0;
        int result = 0;

        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            Integer count = occurrencesCount.get(s.charAt(rightIndex));
            if (Objects.isNull(count)) {
                count = 0;
            }

            occurrencesCount.put(s.charAt(rightIndex), count + 1);

            int mostOccurrences = occurrencesCount.values().stream().mapToInt(i -> i).max().orElse(0);

            while ((rightIndex - leftIndex + 1) - mostOccurrences > k) {
                count = occurrencesCount.get(s.charAt(leftIndex));
                if (Objects.isNull(count)) {
                    count = 0;
                }
                occurrencesCount.put(s.charAt(leftIndex), count - 1);

                leftIndex++;
            }

            result = Math.max(result, (rightIndex - leftIndex + 1));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.printf("A: %d, E: %d\n", solution.characterReplacement("ABAB", 2), 4);

        System.out.printf("A: %d, E: %d\n", solution.characterReplacement("AABABBA", 1), 4);
    }
}
