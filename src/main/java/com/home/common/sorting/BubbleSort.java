/* Description: https://github.com/cyber-kid/interview-preparation/blob/master/algorithms/sorting-algorithms.md */

package com.home.common.sorting;

import static com.home.common.sorting.SortingUtils.swapItems;

class BubbleSort {
    int[] sort(int[] inputArray) {

        for (int i = inputArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    swapItems(inputArray, j, j + 1);
                }
            }
        }

        return inputArray;
    }
}
