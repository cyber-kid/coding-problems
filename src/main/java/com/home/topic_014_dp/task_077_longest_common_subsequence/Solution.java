package com.home.topic_014_dp.task_077_longest_common_subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
//        return longestCommonSubsequenceRec(text1, text2, 0, 0);
        return longestCommonSubsequenceBottomUp(text1, text2);
    }

    private int longestCommonSubsequenceRec(String text1, String text2, int currentPosition1, int currentPosition2) {
        int maxLength = 0;

        if (currentPosition1 == text1.length() || currentPosition2 == text2.length()) {
            return 0;
        }

        if (text1.charAt(currentPosition1) == text2.charAt(currentPosition2)) {
            maxLength = Math.max(maxLength, 1 + longestCommonSubsequenceRec(text1, text2, currentPosition1 + 1, currentPosition2 + 1));
        }

        maxLength = Math.max(maxLength, longestCommonSubsequenceRec(text1, text2, currentPosition1, currentPosition2 + 1));
        maxLength = Math.max(maxLength, longestCommonSubsequenceRec(text1, text2, currentPosition1 + 1, currentPosition2));

        return maxLength;
    }

    private int longestCommonSubsequenceBottomUp(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println(solution.longestCommonSubsequence("abc", "abc")); // 3
        System.out.println(solution.longestCommonSubsequence("abc", "def")); // 0
    }
}
