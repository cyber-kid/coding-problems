package com.home.topic_003_sliding_window.fruit_into_baskets;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int totalFruit(int[] fruits) {
        int result = 0;
        int left = 0;
        Map<Integer, Integer> store = new HashMap<>();

        for (int typeRight : fruits) {
            if (store.containsKey(typeRight)) {
                int count = store.get(typeRight);
                store.put(typeRight, count + 1);
            } else {
                store.put(typeRight, 1);
            }

            while (store.size() > 2) {
                int typeLeft = fruits[left];
                if (store.containsKey(typeLeft)) {
                    int count = store.get(typeLeft);
                    if (count - 1 == 0) {
                        store.remove(typeLeft);
                    } else {
                        store.put(typeLeft, count - 1);
                    }
                }
                left++;
            }

            result = Math.max(result, store.values().stream().mapToInt(i -> i).sum());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] fruits = {1,2,1}; //3
        System.out.println(solution.totalFruit(fruits));

        int[] fruits2 = {0,1,2,2}; //3
        System.out.println(solution.totalFruit(fruits2));

        int[] fruits3 = {1,2,3,2,2}; //4
        System.out.println(solution.totalFruit(fruits3));
    }

}
