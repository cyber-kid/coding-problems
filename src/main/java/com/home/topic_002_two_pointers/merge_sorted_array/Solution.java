package com.home.topic_002_two_pointers.merge_sorted_array;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        int result = nums1.length - 1;

        while (first >= 0 && second >= 0) {
            if (nums1[first] >= nums2[second]) {
                nums1[result] = nums1[first];
                first--;
            } else {
                nums1[result] = nums2[second];
                second--;
            }
            result--;
        }

        while (first >= 0) {
            nums1[result] = nums1[first];
            first--;
            result--;
        }

        while (second >= 0) {
            nums1[result] = nums2[second];
            second--;
            result--;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1, 3, nums2, 3); // 1,2,2,3,5,6

        int[] nums12 = {1};
        int[] nums22 = {};
        solution.merge(nums12, 1, nums22, 0); // 1

        int[] nums13 = {0};
        int[] nums23 = {1};
        solution.merge(nums13, 0, nums23, 1); // 1

        int[] nums14 = {1,2,3,0,0,0,0};
        int[] nums24 = {2,5,6,7};
        solution.merge(nums14, 3, nums24, 4); // 1,2,2,3,5,6,7

        int[] nums15 = {1,2,3,0,0,0,0};
        int[] nums25 = {1,2,5,6};
        solution.merge(nums15, 3, nums25, 4); // 1,1,2,2,3,5,6

        int[] nums16 = {4,0,0,0,0,0};
        int[] nums26 = {1,2,3,5,6};
        solution.merge(nums16, 1, nums26, 5); // 1,2,3,4,5,6
    }
}
