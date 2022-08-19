package com.home.task_020_top_k_frequent_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrencesCount = new HashMap<>();

        for (int num : nums) {
            occurrencesCount.merge(num, 1, Integer::sum);
        }

        List<Integer>[] store = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> occurrenceCount : occurrencesCount.entrySet()) {
            Integer count = occurrenceCount.getValue();
            Integer value = occurrenceCount.getKey();

            List<Integer> elements = store[count];

            if (Objects.isNull(elements)) {
                elements = new ArrayList<>();
                elements.add(value);

                store[count] = elements;
            } else {
                elements.add(value);
            }
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for (int i = store.length - 1; i > 0; i--) {
            List<Integer> integers = store[i];
            if (Objects.nonNull(integers)) {
                for (Integer integer : integers) {
                    result[resultIndex] = integer;
                    if (resultIndex == k - 1) {
                        return result;
                    } else {
                        resultIndex++;
                    }

                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 2)));

        nums = new int[]{1};
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 1)));
    }
}
