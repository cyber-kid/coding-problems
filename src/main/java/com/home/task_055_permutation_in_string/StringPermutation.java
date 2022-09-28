package com.home.task_055_permutation_in_string;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> store = new HashMap<>();

        // create a look up table with all the chars in s1 and the count of occurrences
        for (Character c : s1.toCharArray()) {
            store.merge(c, 1, Integer::sum);
        }

        int start = 0;
        int end = 0;
        int matchedChars = 0;

        // we add one element at a time
        while (end < s2.length()) {
            // if current char is in the look up table we decrease occurrence count
            if (store.containsKey(s2.charAt(end))) {
                int count = store.get(s2.charAt(end));

                if (count == 1) {
                    store.put(s2.charAt(end), 0);
                    // if the occurrence count is 0 we matched the specific char, so we increase the counter
                    matchedChars++;
                } else {
                    store.put(s2.charAt(end), count - 1);
                }
            }

            // if the size of the window is bigger than the size of s1 (pattern) we should shrink the window
            // and increase occurrence count in look up table
            if ((end - start + 1) > s1.length()) {
                if (store.containsKey(s2.charAt(start))) {
                    int count = store.get(s2.charAt(start));
                    // if the count was 0 (matched all occurrences of a specific char)
                    // we should decrease the count for matched chars
                    if (count == 0) {
                        matchedChars--;
                    }
                    store.merge(s2.charAt(start), 1, Integer::sum);
                }
                start++;
            }

            // if matched all the chars (all occurrences) we return true
            if (matchedChars == store.size()) {
                return true;
            }

            end++;
        }

        return false;
    }

    public static void main(String[] args) {
        // true
//        String str = "oidbcaf";
//        String pattern = "abc";

        // false
        String str = "odicf";
        String pattern = "dc";

        StringPermutation solution = new StringPermutation();
        System.out.println(solution.checkInclusion(str, pattern));
    }
}
