package com.home.topic_002_two_pointers.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            if (currentIndex > 0 && nums[currentIndex - 1] == nums[currentIndex]) {
                continue;
            }

            int target = 0 - nums[currentIndex];
            int left = currentIndex + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (target < nums[left] + nums[right]) {
                    right--;
                } else if (target > nums[left] + nums[right]) {
                    left++;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[currentIndex]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);

                    result.add(triplet);
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{0, 0, 0, 0};
        System.out.println(solution.threeSum(nums));

        int[] nums2 = new int[]{-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums2));

    }
}
