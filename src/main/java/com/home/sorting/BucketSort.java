package com.home.sorting;

import java.util.Arrays;

public class BucketSort {
    // For BucketSort to be efficient (O(N)) the amout of unique values should be relatively small
    // In this example we will sort [2,0,2,1,1,0]
    public int[] sort(int[] nums) {
        int[] buckets = new int[3];

        Arrays.fill(buckets, 0);

        for (int num : nums) {
            buckets[num] += 1;
        }

        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                nums[index] = i;
                index++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        BucketSort bucketSort = new BucketSort();

        System.out.println(Arrays.toString(bucketSort.sort(nums)));
    }
}
