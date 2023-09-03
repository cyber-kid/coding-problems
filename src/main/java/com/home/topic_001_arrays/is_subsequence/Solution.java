package com.home.topic_001_arrays.is_subsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int result = s.length();
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                result--;
            }

            tIndex++;
        }

        return result == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abc";
        String t = "ahbgdc";

        System.out.println(solution.isSubsequence(s, t));

        s = "axc";
        t = "ahbgdc";

        System.out.println(solution.isSubsequence(s, t));
    }
}
