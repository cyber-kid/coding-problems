package com.home.solution;

import java.util.Arrays;

public class Solution {
    public boolean findPhytagoenTriplet(int[] array) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                double sumPowerOfTwo = Math.pow(array[i], 2) + Math.pow(array[j], 2);

                for (int k = j + 1; k < array.length; k++) {
                    if (Math.pow(array[k], 2) == sumPowerOfTwo) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = {3, 1, 4, 6, 5};
        boolean result = solution.findPhytagoenTriplet(input);

        System.out.println(result);

        int[] input2 = {10, 4, 6, 12, 5};
        result = solution.findPhytagoenTriplet(input2);

        System.out.println(result);

    }
}
