package com.home.task_015_valid_anagram;

import java.util.Arrays;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return true;
        }

        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);

        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);

        for (int i = 0; i < t.length(); i++) {
            if (sCharArray[i] != tCharArray[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isAnagram("", ""));
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }
}
