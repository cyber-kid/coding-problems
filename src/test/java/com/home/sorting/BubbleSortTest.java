package com.home.sorting;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BubbleSortTest {
    @Test
    public void sortTest() {
        int[] unsortedArray = {4, 5, 1, 9, 7};

        BubbleSort bubbleSort = new BubbleSort();
        int[] sortedArray = bubbleSort.sort(unsortedArray);

        Assertions.assertThat(sortedArray).isSorted();
    }
}
