package com.home.topic_014_dp.task_048_palindromic_substring;

public class Solution {
    public int countSubstrings(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            result += expandPalindrome(i, i, s);
            result += expandPalindrome(i, i + 1, s);
        }

        return result;
    }

    private int expandPalindrome(int left, int right, String s) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;

            left -= 1;
            right += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
    }
}
