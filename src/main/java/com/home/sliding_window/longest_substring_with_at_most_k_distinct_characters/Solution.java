package com.home.sliding_window.longest_substring_with_at_most_k_distinct_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int findLength(String str, int k) {
        int result = 0;
        int left = 0;
        Map<Character, Integer> store = new HashMap<>();

        for (int right = 0; right < str.length(); right++) {
            char charAtRight = str.charAt(right);
            store.merge(charAtRight, 1, Integer::sum);

            while (store.size() > k) {
                char charAtLeft = str.charAt(left);
                if (store.containsKey(charAtLeft)) {
                    int count = store.get(charAtLeft);
                    if (count == 1) {
                        store.remove(charAtLeft);
                    } else {
                        store.put(charAtLeft, count - 1);
                    }
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "araaci"; // k = 2 result = 4
        System.out.println(findLength(str, 2));

        str = "araaci"; // k = 1 result = 2
        System.out.println(findLength(str, 1));

        str = "cbbebi"; // k = 3 result = 5
        System.out.println(findLength(str, 3));

        str = "cbbebi"; // k = 10 result = 6
        System.out.println(findLength(str, 10));
    }
}
