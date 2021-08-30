/* Description: https://github.com/cyber-kid/interview-preparation/blob/master/algorithms/sorting-algorithms.md */

package com.home.common.sorting;

class InsertionSort {
    int[] sort(int[] inputArray) {
        for (int out = 1; out < inputArray.length; out++) {

            int temp = inputArray[out];
            int in = out;

            while (in > 0 && inputArray[in - 1] > temp) {
                inputArray[in] = inputArray[in - 1];
                in--;
            }

            inputArray[in] = temp;
        }

        return inputArray;
    }
}
