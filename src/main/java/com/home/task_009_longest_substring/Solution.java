package com.home.task_009_longest_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> store = new HashMap<>();

        int result = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (store.containsKey(s.charAt(i))) {
                start = Math.max(start, store.get(s.charAt(i)));
            }

            result = Math.max(result, i - start);

            store.put(s.charAt(i), i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("abcabcbb"), 3);
//        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("bbbbb"), 1);
//        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("pwwkew"), 3);
//        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("au"), 2);
//        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring(" "), 1);
//        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("dvdf"), 3);
//        System.out.printf("A: %d, E: %d \n", lengthOfLongestSubstring("abba"), 2);
    }
}
