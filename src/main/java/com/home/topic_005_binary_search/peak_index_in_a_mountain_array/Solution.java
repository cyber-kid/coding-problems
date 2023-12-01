package com.home.topic_005_binary_search.peak_index_in_a_mountain_array;

public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int peak = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == arr.length - 1 || arr[mid] > arr[mid + 1]) {
                peak = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return peak;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {0,1,0}; // 1
        int result = solution.peakIndexInMountainArray(arr);
        System.out.println(result);

        int[] arr2 = {0,2,1,0}; // 1
        result = solution.peakIndexInMountainArray(arr2);
        System.out.println(result);

        int[] arr3 = {0,10,5,2}; // 1
        result = solution.peakIndexInMountainArray(arr3);
        System.out.println(result);

        int[] arr4 = {0,4,10,2}; // 2
        result = solution.peakIndexInMountainArray(arr4);
        System.out.println(result);

        int[] arr5 = {1}; // 0
        result = solution.peakIndexInMountainArray(arr5);
        System.out.println(result);
    }
}
