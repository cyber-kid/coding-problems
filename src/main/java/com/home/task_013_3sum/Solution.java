package com.home.task_013_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                List<Integer> triplet = new ArrayList<>();
                int sum = nums[i] + nums[leftIndex] + nums[rightIndex];

                if (sum == 0) {
                    triplet.add(nums[i]);
                    triplet.add(nums[leftIndex]);
                    triplet.add(nums[rightIndex]);

                    result.add(triplet);

                    leftIndex++;
                    while (nums[leftIndex] == nums[leftIndex - 1] && leftIndex < rightIndex) {
                        leftIndex++;
                    }
                } else if (sum > 0) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{0, 0, 0, 0};
        System.out.println(solution.threeSum(nums));

    }
}
