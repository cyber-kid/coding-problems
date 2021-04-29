/* Description: https://github.com/cyber-kid/interview-preparation/blob/master/algorithms/sorting-algorithms.md */

package com.home.common.sorting;

import static com.home.common.sorting.SortingUtils.swapItems;

class SelectionSort {
    int[] sort(int[] inputArray) {
        for (int out = 0; out < inputArray.length - 1; out++) {
            int min = out;

            for (int in = out + 1; in < inputArray.length; in++) {
                if (inputArray[in] < inputArray[min]) {
                    min = in;
                }
            }

            swapItems(inputArray, min, out);
        }

        return inputArray;
    }
}
