package com.home.topic_014_dp.longest_palindromic_substring;

public class Solution {
    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            result = expandPalindrome(i, i, result, s.toLowerCase());
            result = expandPalindrome(i, i + 1, result, s.toLowerCase());
        }

        return result;
    }

    private String expandPalindrome(int left, int right, String result, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if ((right - left + 1) > result.length()) {
                result = s.substring(left, right + 1);
            }

            left -= 1;
            right += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("11"));
    }
}
