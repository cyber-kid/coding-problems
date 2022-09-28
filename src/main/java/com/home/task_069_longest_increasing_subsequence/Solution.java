package com.home.task_069_longest_increasing_subsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
//        return lengthOfLISRec(nums, 0);

        return lengthOfLISBottomUp(nums);
    }

    private int lengthOfLISRec(int[] nums, int currentIndex) {
        // if it is the last element in the array the possible length is 1 (the element itself)
        if (currentIndex == nums.length - 1) {
            return 1;
        }

        // we have to options how to verify all possible combinations
        int count = 0;
        // we can include the current element if it is smaller than the next one
        if (nums[currentIndex] < nums[currentIndex + 1]) {
            // for the branch where we include the current element
            // the length is 1 (the current element) plus the length of the subarray that starts from the next element
            count = 1 + lengthOfLISRec(nums, currentIndex + 1);
        }

        // to merge 2 branches at the root we take the max length from both
        return Math.max(count, lengthOfLISRec(nums, currentIndex + 1));
    }

    private int lengthOfLISBottomUp(int[] nums) {
        // dp array will contain the LIS for a subarray that ends on a specific index
        int[] dp = new int[nums.length];
        // we will init each cell with 1 (each element is a subarray)
        Arrays.fill(dp, 1);

        // in outer loop we iterate over the elements starting from the index 1
        for (int i = 1; i < nums.length; i++) {
            // in the inner loop we iterate over the elements that are coming before the current element (coming from the outer loop)
            for (int j = 0; j < i; j++) {
                // if the current element is bigger than the one from the inner loop it means that it can contribute to the subarray
                if (nums[i] > nums[j]) {
                    // we take the max value of current index or of the index of the element from inner loop + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int result = solution.lengthOfLIS(nums); //4
        System.out.println(result);

        nums = new int[]{0,1,0,3,2,3};
        result = solution.lengthOfLIS(nums); //4
        System.out.println(result);

        nums = new int[]{1,2,4,3};
        result = solution.lengthOfLIS(nums); //3
        System.out.println(result);
    }
}
