package com.home.task_053_longest_substing_max_k_distinct_chars;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int start = 0;
        int end = 0;
        int result = 0;
        Map<Character, Integer> store = new HashMap<>();

        while (end < str.length()) {
            store.merge(str.charAt(end), 1, Integer::sum);

            if (store.size() <= k) {
                result = Math.max(result, end - start + 1);
            }

            while (store.size() > k) {
                if (store.containsKey(str.charAt(start))) {
                    int count = store.get(str.charAt(start));
                    if (count == 1) {
                        store.remove(str.charAt(start));
                    } else {
                        store.put(str.charAt(start), count - 1);
                    }
                }
                start++;
            }

            end++;
        }

        return result;
    }

    public static void main(String[] args) {
//        String str = "araaci"; // k = 2 result = 4
//        String str = "araaci"; // k = 1 result = 2
//        String str = "cbbebi"; // k = 3 result = 5
        String str = "cbbebi"; // k = 10 result = 6
        System.out.println(findLength(str, 10));
    }
}