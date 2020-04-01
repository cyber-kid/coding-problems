package com.home.sorting;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void sortTest() {
        int[] unsortedArray = {4, 5, 1, 9, 7};

        SelectionSort selectionSort = new SelectionSort();
        int[] sortedArray = selectionSort.sort(unsortedArray);

        Assertions.assertThat(sortedArray).isSorted();
    }
}
