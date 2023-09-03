package com.home.topic_001_arrays.valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> store = new HashMap<>();

        for (Character c: s.toCharArray()) {
            store.merge(c, 1, Integer::sum);
        }

        for (char c: t.toCharArray()) {
            if (store.containsKey(c)) {
                int count = store.get(c);
                if (count == 1) {
                    store.remove(c);
                } else {
                    store.put(c, count - 1);
                }
            }
        }

        return store.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isAnagram("", ""));
        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }
}
