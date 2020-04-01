package com.home.sorting;

class SortingUtils {
    static void swapItems(int[] inputArray, int fromIndex, int toIndex) {
        int temp = inputArray[toIndex];
        inputArray[toIndex] = inputArray[fromIndex];
        inputArray[fromIndex] = temp;
    }
}
