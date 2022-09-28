package com.home.task_067_max_product_subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{2, 3, -2, 4};
        int result = solution.maxProduct(nums);
        System.out.println(result); // 6

        nums = new int[]{-2,0,-1};
        result = solution.maxProduct(nums);
        System.out.println(result); // 0

        nums = new int[]{-3,-1,-1};
        result = solution.maxProduct(nums);
        System.out.println(result); // 3
    }
}

