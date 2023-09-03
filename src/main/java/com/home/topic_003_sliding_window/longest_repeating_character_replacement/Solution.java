package com.home.topic_003_sliding_window.longest_repeating_character_replacement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        Map<Character, Integer> store = new HashMap<>();
        int mostOccur = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            int occurs = store.getOrDefault(s.charAt(right), 0);
            store.put(s.charAt(right), occurs + 1);
            mostOccur = Math.max(mostOccur, occurs + 1);

            while ((right - left + 1) - mostOccur > k) {
                Character leftChar = s.charAt(left);

                occurs = store.get(leftChar);
                if (occurs - 1 == 0) {
                    store.remove(leftChar);
                } else {
                    store.put(leftChar, occurs - 1);
                }

                left++;
                mostOccur = store.values().stream().mapToInt(item -> item).max().orElse(0);
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.printf("A: %d, E: %d\n", solution.characterReplacement("ABAB", 2), 4);

        System.out.printf("A: %d, E: %d\n", solution.characterReplacement("AABABBA", 1), 4);
    }
}
