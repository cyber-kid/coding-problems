package com.home.topic_014_dp.task_066_decode_ways;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numDecodings(String s) {
//        return numDecodingsRec(s, 0);

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return numDecodingsTopDown(s, 0, dp);
    }

    private int numDecodingsRec(String s, int currentIndex) {
        if (currentIndex == s.length()) {
            return 1;
        }

        if (s.charAt(currentIndex) == '0') {
            return 0;
        }

        if (currentIndex == s.length() - 1) {
            return 1;
        }

        int count = 0;

        count += numDecodingsRec(s, currentIndex + 1);

        if (Integer.parseInt(s.substring(currentIndex, currentIndex + 2)) <= 26) {
            count += numDecodingsRec(s, currentIndex + 2);
        }

        return count;
    }

    private int numDecodingsTopDown(String s, int currentIndex, Map<Integer, Integer> dp) {
        if (dp.containsKey(currentIndex)) {
            return dp.get(currentIndex);
        }

        if (s.charAt(currentIndex) == '0') {
            return 0;
        }

        if (currentIndex == s.length() - 1) {
            return 1;
        }

        int count = 0;

        count += numDecodingsTopDown(s, currentIndex + 1, dp);

        if (Integer.parseInt(s.substring(currentIndex, currentIndex + 2)) <= 26) {
            count += numDecodingsTopDown(s, currentIndex + 2, dp);
        }

        dp.put(currentIndex, count);
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.numDecodings("11106"); // 2
        System.out.println(result);

        result = solution.numDecodings("12"); // 2
        System.out.println(result);
    }
}
