/* Description: https://github.com/cyber-kid/interview-preparation/blob/master/algorithms/sorting-algorithms.md */

package com.home.common.sorting;

class MergeSort {
    int[] sort(int[] inputArray) {
        int[] workspaceArray = new int[inputArray.length];

        mergeSort(inputArray, workspaceArray, 0, inputArray.length - 1);

        return inputArray;
    }

    private void mergeSort(int[] iArray, int[] wArray, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) {
            return;
        }

        int mid = (firstIndex + lastIndex) / 2;

        mergeSort(iArray, wArray, firstIndex, mid);

        mergeSort(iArray, wArray, mid + 1, lastIndex);

        merge(iArray, wArray, firstIndex, mid + 1, lastIndex);
    }

    private void merge(int[] iArray, int[] wArray, int firstIndex, int mid, int lastIndex) {
        // index is needed to iterate over sorted elements
        int index = 0;
        // numberOfElements is needed to track how many items should be copied back from workspaceArray
        int numberOfElements = (lastIndex + 1) - firstIndex;
        // firstIndexFirstHalf is needed to iterate over first half to be merged
        // firstIndex should be unchanged to know where in inputArray to put merged(sorted) items
        int firstIndexFirstHalf = firstIndex;
        // secondIndexSecondtHalf is needed because mid will be changed during execution
        int secondIndexSecondtHalf = mid - 1;

        while (firstIndexFirstHalf <= secondIndexSecondtHalf && mid <= lastIndex) {
            if (iArray[firstIndexFirstHalf] < iArray[mid]) {
                wArray[index++] = iArray[firstIndexFirstHalf++];
            } else {
                wArray[index++] = iArray[mid++];
            }
        }

        while (firstIndexFirstHalf <= secondIndexSecondtHalf) {
            wArray[index++] = iArray[firstIndexFirstHalf++];
        }

        while (mid <= lastIndex) {
            wArray[index++] = iArray[mid++];
        }

        for (index = 0; index < numberOfElements; index++) {
            // after we merged(sorted) items in workspaceArray we should put them back into inputArray starting from the same index
            iArray[firstIndex + index] = wArray[index];
        }
    }
}
