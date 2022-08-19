package com.home.task_021_group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String charsStr = String.valueOf(chars);

            if (store.containsKey(charsStr)) {
                List<String> anagrams = store.get(charsStr);
                anagrams.add(s);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(s);

                store.put(charsStr, anagrams);
            }
        }

        return new ArrayList<>(store.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] s = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(solution.groupAnagrams(s));

        s = new String[]{""};
        System.out.println(solution.groupAnagrams(s));

        s = new String[]{"a"};
        System.out.println(solution.groupAnagrams(s));
    }
}
