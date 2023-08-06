package com.home.sliding_window.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solve(String s, String t) {
        String result = "";
        Map<Character, Integer> store = new HashMap<>();

        // we build a look up table with all the chars from the pattern
        // count the occurrences for that char
        for (Character c : t.toCharArray()) {
            store.merge(c, 1, Integer::sum);
        }

        int start = 0;
        int end = 0;
        int matchedChars = 0;

        while (end < s.length()) {
            // if the look up table contains the current char
            // we decrease the count of occurrences for that char
            if (store.containsKey(s.charAt(end))) {
                int count = store.get(s.charAt(end));

                if (count == 1) {
                    // if after decreasing the count it is 0 it means that one char from the pattern is matched
                    matchedChars++;
                    store.put(s.charAt(end), 0);
                } else {
                    store.put(s.charAt(end), count - 1);
                }
            }

            // if we matched all the chars from the pattern
            while (matchedChars == store.size()) {
                // update the result
                if (result.isEmpty() || result.length() > (end - start + 1)) {
                    result = s.substring(start, end + 1);
                }

                // and shrink the window (because we want the smallest substring)
                // we updated the look up table
                if (store.containsKey(s.charAt(start))) {
                    int count = store.get(s.charAt(start));

                    // if the occurrence count for a char was 0
                    // we decrement the count for matched chars
                    if (count == 0) {
                        matchedChars--;
                        store.put(s.charAt(start), 1);
                    } else {
                        store.put(s.charAt(start), count + 1);
                    }
                }

                start++;
            }

            // add next element to the window
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.printf("A: %s, E: %s\n", solution.solve("ADOBECODEBANC", "ABC"), "BANC");
        System.out.printf("A: %s, E: %s\n", solution.solve("a", "a"), "a");
        System.out.printf("A: %s, E: %s\n", solution.solve("a", "aa"), "");
        System.out.printf("A: %s, E: %s\n", solution.solve("aa", "aa"), "aa");
    }
}
