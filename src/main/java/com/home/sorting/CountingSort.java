package com.home.sorting;

public class CountingSort {
    int[] sort(int[] inputArray) {
        int maxElement = 0;
        for (int i : inputArray) {
            if (i > maxElement) {
                maxElement = i;
            }
        }

        int[] occurrencesCountArray = new int[maxElement + 1];
        for (int i : inputArray) {
            occurrencesCountArray[i] = occurrencesCountArray[i] + 1;
        }

        for (int i = 1; i < occurrencesCountArray.length; i++) {
            occurrencesCountArray[i] = occurrencesCountArray[i - 1] + occurrencesCountArray[i];
        }

        int[] result = new int[inputArray.length];
        for (int i = inputArray.length - 1; i >= 0; i--) {
            int element = inputArray[i];
            int newPosition = occurrencesCountArray[element] - 1;
            occurrencesCountArray[element] = occurrencesCountArray[element] - 1;

            result[newPosition] = element;
        }

        return result;
    }
}
