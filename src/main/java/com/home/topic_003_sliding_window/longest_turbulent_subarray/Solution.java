package com.home.topic_003_sliding_window.longest_turbulent_subarray;

public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int result = 1;
        int previousSign = 2;
        int left = 0;
        int right = 1;
        while (right < arr.length) {
            int sign = Integer.compare(arr[right - 1], arr[right]);
            if (sign == 0) {
                left = right;
            } else if (previousSign == sign) {
                left = right - 1;
            }
            previousSign = sign;
            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {9,4,2,10,7,8,8,1,9}; //5
        int result = solution.maxTurbulenceSize(arr);
        System.out.println(result);

        int[] arr2 = {4,8,12,16}; //2
        result = solution.maxTurbulenceSize(arr2);
        System.out.println(result);

        int[] arr3 = {9}; //1
        result = solution.maxTurbulenceSize(arr3);
        System.out.println(result);

        int[] arr4 = {9,9}; //1
        result = solution.maxTurbulenceSize(arr3);
        System.out.println(result);
    }
}
