package com.home.common.sorting;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class InsertionSortTest {
    @Test
    public void sortTest() {
        int[] unsortedArray = {4, 5, 1, 9, 7};

        InsertionSort insertionSort = new InsertionSort();
        int[] sortedArray = insertionSort.sort(unsortedArray);

        Assertions.assertThat(sortedArray).isSorted();
    }
}
