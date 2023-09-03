package com.home.topic_002_two_pointers.valid_palindrome_ii;

public class Solution {
    public boolean validPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s.substring(left + 1, right + 1)) || isPalindrome(s.substring(left, right));
            }
        }

        return true;
    }

    private boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String str = "aba"; // true
        System.out.println(solution.validPalindrome(str));

        str = "abca"; // true
        System.out.println(solution.validPalindrome(str));

        str = "abc"; // false
        System.out.println(solution.validPalindrome(str));

        str = "aydmda"; // true
        System.out.println(solution.validPalindrome(str));
    }
}
