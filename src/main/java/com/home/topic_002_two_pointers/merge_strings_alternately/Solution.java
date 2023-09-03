package com.home.topic_002_two_pointers.merge_strings_alternately;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int first = 0;
        int second = 0;
        StringBuilder result = new StringBuilder();

        while (first < word1.length() && second < word2.length()) {
            result.append(word1.charAt(first));
            result.append(word2.charAt(second));

            first++;
            second++;
        }

        while (first < word1.length()) {
            result.append(word1.charAt(first));

            first++;
        }

        while (second < word2.length()) {
            result.append(word2.charAt(second));

            second++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String word1 = "ab", word2 = "pqrs"; // apbqrs
        System.out.println(solution.mergeAlternately(word1, word2));

        word1 = "abcd";
        word2 = "pq"; // apbqcd
        System.out.println(solution.mergeAlternately(word1, word2));
    }
}
