package com.home.topic_002_two_pointers.find_pythagorean_triplet_in_an_unsorted_array;

import java.util.Arrays;
import java.util.Collection;

public class Solution {

    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        Solution solution = new Solution();

        Collection<Integer> numbers = Arrays.asList(5, 1, 3, 2, 4); // 5 - 3,4
        boolean result = solution.containsPythagoras(numbers);
        System.out.println(result);

        numbers = Arrays.asList(10, 4, 6, 12, 5); // false
        result = solution.containsPythagoras(numbers);
        System.out.println(result);
    }

    public boolean containsPythagoras(final Collection<Integer> numbers) {
        int[] array = numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < array.length; i++) {
            array[i] *= array[i];
        }

        Arrays.sort(array);

        for (int i = array.length - 1; i > 1; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                int sum = array[l] + array[r];

                if (sum < array[i]) {
                    l++;
                } else if (sum > array[i]) {
                    r--;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}
