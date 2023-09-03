package com.home.topic_003_sliding_window.longest_substring_without_repeating_characters;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        List<Character> store = new ArrayList<>();

        for (int right = 0; right < s.length(); right++) {
            while (store.contains(s.charAt(right))) {
                Character character = s.charAt(left);
                store.remove(character);
                left++;
            }
            store.add(s.charAt(right));

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("abcabcbb"), 3);
        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("bbbbb"), 1);
        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("pwwkew"), 3);
        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("au"), 2);
        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring(" "), 1);
        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("dvdf"), 3);
        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("abba"), 2);
    }
}
