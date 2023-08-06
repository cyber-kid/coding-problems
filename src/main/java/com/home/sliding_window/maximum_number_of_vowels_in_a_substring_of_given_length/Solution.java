package com.home.sliding_window.maximum_number_of_vowels_in_a_substring_of_given_length;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int maxVowels(String s, int k) {
        int result = 0;
        int left = 0;
        int count = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);
            if (vowels.contains(key)) {
                count++;
            }

            if (right - left + 1 == k) {
                result = Math.max(result, count);

                char keyLeft = s.charAt(left);
                if (vowels.contains(keyLeft)) {
                    count--;
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "abciiidef"; //3
        int result = solution.maxVowels(str, 3);
        System.out.println(result);

        str = "aeiou"; //2
        result = solution.maxVowels(str, 2);
        System.out.println(result);

        str = "leetcode"; //2
        result = solution.maxVowels(str, 3);
        System.out.println(result);
    }
}
