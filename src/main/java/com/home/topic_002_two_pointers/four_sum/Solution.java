package com.home.topic_002_two_pointers.four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public void kSum(int start, int[] nums, long target, int k, List<List<Integer>> result, List<Integer> quadruplet) {
        if (k != 2) {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i - 1] == nums[i]) {
                    continue;
                }

                quadruplet.add(nums[i]);
                target -= nums[i];
                k--;
                kSum(i + 1, nums, target, k, result, quadruplet);
                quadruplet.remove((Integer) nums[i]);
            }
        } else {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                long sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    List<Integer> match = new ArrayList<>(quadruplet);
                    match.add(nums[left]);
                    match.add(nums[right]);

                    result.add(match);

                    left++;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                }
            }
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> quadruplet = new ArrayList<>();

        Arrays.sort(nums);

        kSum(0, nums, target, 4, result, quadruplet);

        return result;

//        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 && nums[i - 1] == nums[i]) {
//                continue;
//            }
//            long first = nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (j > i + 1 && nums[j - 1] == nums[j]) {
//                    continue;
//                }
//                long second = nums[j];
//
//                int left = j + 1;
//                int right = nums.length - 1;
//
//                while (left < right) {
//                    long sum = first + second + nums[left] + nums[right];
//
//                    if (target < sum) {
//                        right--;
//                    } else if (target > sum) {
//                        left++;
//                    } else {
//                        List<Integer> quadruplet = new ArrayList<>();
//                        quadruplet.add(nums[i]);
//                        quadruplet.add(nums[j]);
//                        quadruplet.add(nums[left]);
//                        quadruplet.add(nums[right]);
//
//                        result.add(quadruplet);
//
//                        left++;
//                        while (nums[left] == nums[left - 1] && left < right) {
//                            left++;
//                        }
//
//                    }
//                }
//            }
//        }
//
//        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(solution.fourSum(nums, 0));

        int[] nums2 = {2,2,2,2,2};
        System.out.println(solution.fourSum(nums2, 8));

        int[] nums3 = {-2,-1,-1,1,1,2,2};
        System.out.println(solution.fourSum(nums3, 0));

        int[] nums4 = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(solution.fourSum(nums4, -294967296));
    }
}
