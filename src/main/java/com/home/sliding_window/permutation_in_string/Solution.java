package com.home.sliding_window.permutation_in_string;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        Map<Character, Integer> store = new HashMap<>();

        for (char c: s1.toCharArray()) {
            store.merge(c, 1, Integer::sum);
        }

        for (int right = 0; right < s2.length(); right++) {
            char key = s2.charAt(right);
            if (store.containsKey(key)) {
                store.merge(key, 1, (o, n) -> o - n);
            }

            if (right - left + 1 == s1.length()) {
                if (store.values().stream().mapToInt(i -> i).allMatch(i -> i == 0)) {
                    return true;
                }

                char leftKey = s2.charAt(left);
                if (store.containsKey(leftKey)) {
                    store.merge(leftKey, 1, Integer::sum);
                }
                left++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // true
        String s2 = "oidbcaf";
        String s1 = "abc";
        System.out.println(solution.checkInclusion(s1, s2));

        // false
        s2 = "odicf";
        s1 = "dc";
        System.out.println(solution.checkInclusion(s1, s2));

        // true
        s2 = "eidbaooo";
        s1 = "ab";
        System.out.println(solution.checkInclusion(s1, s2));

        // false
        s2 = "eidboaoo";
        s1 = "ab";
        System.out.println(solution.checkInclusion(s1, s2));

        // true
        s2 = "dcda";
        s1 = "adc";
        System.out.println(solution.checkInclusion(s1, s2));

        // false
        s2 = "ooolleoooleh";
        s1 = "hello";
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
