package com.home.common.sorting;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MergeSortTest {
    @Test
    public void sortTest() {
        int[] unsortedArray = {4, 5, 1, 9, 7};

        MergeSort mergeSort = new MergeSort();
        int[] sortedArray = mergeSort.sort(unsortedArray);

        Assertions.assertThat(sortedArray).isSorted();
    }
}
