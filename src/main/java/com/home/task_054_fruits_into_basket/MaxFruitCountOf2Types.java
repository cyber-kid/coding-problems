package com.home.task_054_fruits_into_basket;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int result = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> store = new HashMap<>();

        while (end < arr.length) {
            store.merge(arr[end], 1, Integer::sum);

            if (store.size() >= 2) {
                result = Math.max(result, end - start + 1);
            }

            while (store.size() > 2) {
                char key = arr[start];
                if (store.containsKey(key)) {
                    int count = store.get(key);
                    if (count == 1) {
                        store.remove(key);
                    } else {
                        store.put(key, count - 1);
                    }
                }

                start++;
            }

            end++;
        }

        return result;
    }

    public static void main(String[] args) {
//        char[] arr = new char[]{'A', 'B', 'C', 'A', 'C'}; // result = 3
        char[] arr = new char[]{'A', 'B', 'C', 'B', 'B', 'C'}; // result = 5
        System.out.println(findLength(arr));
    }

}
