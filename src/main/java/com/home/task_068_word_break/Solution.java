package com.home.task_068_word_break;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
//        return wordBreakRec(s, wordDict);

//        Map<String, Boolean> dp = new HashMap<>();
//        return wordBreakTopDown(s, wordDict, dp);

        return wordBreakBottomUp(s, wordDict);
    }

    private boolean wordBreakRec(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        for (String word : wordDict) {
            if (s.contains(word)) {
                s = s.replace(word, "");
                boolean result = wordBreakRec(s, wordDict);

                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean wordBreakTopDown(String s, List<String> wordDict, Map<String, Boolean> dp) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        if (s.isEmpty()) {
            return true;
        }

        for (String word : wordDict) {
            if (s.contains(word)) {
                s = s.replace(word, "");
                boolean result = wordBreakTopDown(s, wordDict, dp);

                if (result) {
                    dp.put(s, true);
                    return true;
                }
            }
        }

        dp.put(s, false);
        return false;
    }

    private boolean wordBreakBottomUp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (((i + word.length()) <= s.length()) && s.substring(i, i + word.length()).equalsIgnoreCase(word)) {
                    dp[i] = dp[i + word.length()];
                }

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> wordDict = Stream.of("leet","code").collect(Collectors.toList());
        boolean result = solution.wordBreak("leetcode", wordDict); // true
        System.out.println(result);

        wordDict = Stream.of("apple","pen").collect(Collectors.toList());
        result = solution.wordBreak("applepenapple", wordDict); // true
        System.out.println(result);

        wordDict = Stream.of("cats","dog","sand","and","cat").collect(Collectors.toList());
        result = solution.wordBreak("catsandog", wordDict); // false
        System.out.println(result);
    }
}
