package com.home.common.sorting;

import org.junit.Test;

import java.util.Arrays;

public class CountingSortTest {
    @Test
    public void sortTest() {
        int[] input = {4, 2, 1, 2, 0};

        CountingSort countingSort = new CountingSort();
        int[] result = countingSort.sort(input);

        System.out.println(Arrays.toString(result));
    }
}
