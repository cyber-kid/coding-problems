package com.home.task_012_product_of_array_except_self;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prefix = 1 * nums[0];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));

        nums = new int[]{-1,1,0,-3,3};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }
}
