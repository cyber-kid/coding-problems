package com.home.solution1;

import java.util.HashMap;
import java.util.List;

public class Solution {
    public static int countDuplicate(List<Integer> numbers) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int result = 0;

        for (Integer element : numbers) {
            if (store.containsKey(element)) {
                Integer count = store.get(element);

                if (count == 1) {
                    result++;
                }

                store.put(element, ++count);
            } else {
                store.put(element, 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();



    }
}
