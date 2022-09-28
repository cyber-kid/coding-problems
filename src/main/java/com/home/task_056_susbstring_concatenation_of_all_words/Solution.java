package com.home.task_056_susbstring_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private final HashMap<String, Integer> wordCount = new HashMap<>();
    private int n;
    private int wordLength;
    private int substringSize;
    private int k;

    private void slidingWindow(int left, String s, List<Integer> answer) {
        HashMap<String, Integer> wordsFound = new HashMap<>();
        int wordsUsed = 0;
        boolean excessWord = false;

        // Do the same iteration pattern as the previous approach - iterate
        // word_length at a time, and at each iteration we focus on one word
        for (int right = left; right <= n - wordLength; right += wordLength) {

            String sub = s.substring(right, right + wordLength);
            if (!wordCount.containsKey(sub)) {
                // Mismatched word - reset the window
                wordsFound.clear();
                wordsUsed = 0;
                excessWord = false;
                left = right + wordLength;
            } else {
                // If we reached max window size or have an excess word
                while (right - left == substringSize || excessWord) {
                    String leftmostWord = s.substring(left, left + wordLength);
                    left += wordLength;
                    wordsFound.put(leftmostWord, wordsFound.get(leftmostWord) - 1);

                    if (wordsFound.get(leftmostWord) >= wordCount.get(leftmostWord)) {
                        // This word was an excess word
                        excessWord = false;
                    } else {
                        // Otherwise we actually needed it
                        wordsUsed--;
                    }
                }

                // Keep track of how many times this word occurs in the window
                wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
                if (wordsFound.get(sub) <= wordCount.get(sub)) {
                    wordsUsed++;
                } else {
                    // Found too many instances already
                    excessWord = true;
                }

                if (wordsUsed == k && !excessWord) {
                    // Found a valid substring
                    answer.add(left);
                }
            }
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            slidingWindow(i, s, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // result [0,9]
//        String s = "barfoothefoobarman";
//        String[] words = new String[]{"foo","bar"};

        // result []
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word","good","best","word"};

        // result [6,9,12]
//        String s = "barfoofoobarthefoobarman";
//        String[] words = new String[]{"bar","foo","the"};

        // result [8]
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = new String[]{"word","good","best","good"};

        // result [13]
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = new String[]{"fooo","barr","wing","ding","wing"};
        System.out.println(solution.findSubstring(s, words));
    }
}
