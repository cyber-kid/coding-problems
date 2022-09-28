package com.home.task_064_partion_equal_subset_sum;

import java.util.Objects;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

//        return canPartitionRec(nums, sum / 2, 0);

        // the dp table has all possible sums as columns
        // and all available items as rows
        // on the crossing we will have a boolean flag that indicates
        // if we can get the specified sum including specified item in the result
        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
//        return canPartitionTopDown(nums, sum / 2, 0, dp);

        return canPartitionBottomUp(nums, dp);
    }

    // recursion
    private boolean canPartitionRec(int[] nums, int sum, int currentItem) {
        if (sum - nums[currentItem] == 0) {
            return true;
        }

        if (currentItem == nums.length - 1) {
            return false;
        }

        // if the current item is less than the target sum it means that we can use this item to build the target sum
        if (nums[currentItem] < sum) {
            // if we can build the rest of target sum (without using this item)
            // we can build the whole target sum and we can return
            // we return only if we can build the target sum
            if (canPartitionRec(nums, sum - nums[currentItem], currentItem + 1)) {
                return true;
            }
        }

        // if we cannot build a target sum including the current item,
        // we try without it and return the result
        return canPartitionRec(nums, sum, currentItem + 1);
    }

    // memoization
    private boolean canPartitionTopDown(int[] nums, int sum, int currentItem, Boolean[][] dp) {
        if (sum - nums[currentItem] == 0) {
            return true;
        }

        if (currentItem == nums.length - 1) {
            return false;
        }

        if (Objects.nonNull(dp[currentItem][sum])) {
            return dp[currentItem][sum];
        }

        if (nums[currentItem] < sum) {
            boolean result = canPartitionTopDown(nums, sum - nums[currentItem], currentItem + 1, dp);
            if (result) {
                // we need to remember the results of computation
                dp[currentItem][sum] = true;
                return true;
            }
        }

        // we need to remember the results of computation
        dp[currentItem][sum] = canPartitionTopDown(nums, sum, currentItem + 1, dp);
        return dp[currentItem][sum];
    }

    // tabulation
    private boolean canPartitionBottomUp(int[] nums, Boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s < dp[0].length; s++) {
            dp[0][s] = (nums[0] == s);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int s = 1; s < dp[i].length; s++) {
                if (s >= nums[i] && dp[i - 1][s - nums[i]]) {
                    dp[i][s] = dp[i - 1][s - nums[i]];
                } else {
                    dp[i][s] = dp[i-1][s];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,5,11,5};
        boolean result = solution.canPartition(nums); // true

        System.out.println(result);

        nums = new int[]{1,2,3,5};
        result = solution.canPartition(nums); // false

        System.out.println(result);

        nums = new int[]{2, 2, 1, 1};
        result = solution.canPartition(nums); // true

        System.out.println(result);
    }
}
