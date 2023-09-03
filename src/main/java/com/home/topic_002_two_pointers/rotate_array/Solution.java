package com.home.topic_002_two_pointers.rotate_array;

import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        rotateOptimal(nums, k);
    }

    private void rotateOptimal(int[] nums, int k) {
        reverseArray(nums, 0, nums.length - 1);

        k = k % nums.length;

        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }

    private void rotateWithExtraMemory(int[] nums, int k) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int newPosition = i + k;
            if (newPosition >= nums.length) {
                newPosition = newPosition % nums.length;
            }

            result[newPosition] = nums[i];
        }

        nums = result;

        System.out.println(Arrays.toString(nums));
    }

    // O(1) extra memory
    private void rotateBruteForce(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }

            nums[0] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,2,3,4,5,6,7};
        solution.rotate(nums, 3);

        int[] nums2 = {-1,-100,3,99};
        solution.rotate(nums2, 2);

        int[] nums3 = {-1};
        solution.rotate(nums3, 2);
    }
}
