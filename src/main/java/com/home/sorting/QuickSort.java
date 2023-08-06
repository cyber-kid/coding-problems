package com.home.sorting;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] nums, int start, int end) {
        // if the array has only one element it is sorted
        if (end - start <= 0) {
            return;
        }

        // pick the last element like a pivot
        int pivot = nums[end];

        // move all elements that are smaller than pivot to the left side
        int leftIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[leftIndex];
                nums[leftIndex] = nums[i];
                nums[i] = temp;
                leftIndex++;
            }
        }

        // put pivot after the elements that are smaller tan pivot
        nums[end] = nums[leftIndex];
        nums[leftIndex] = pivot;

        // do the same for the not sorted parts that are separated by the pivot
        sort(nums, start, leftIndex - 1);
        sort(nums, leftIndex + 1, end);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] nums = {6,2,4,1,3};

        quickSort.sort(nums, 0, nums.length -1);

        System.out.println(Arrays.toString(nums));
    }
}
