package com.home.topic_003_sliding_window.sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // we store indices
        ArrayDeque<Integer> store = new ArrayDeque<>();

        int start = 0;
        int end = 0;
        int resultIndex = 0;


        while (end < nums.length) {
            // remove all items from the store that are smaller than the current

            while (!store.isEmpty() && nums[end] >= nums[store.peekLast()]) {
                store.removeLast();
            }

            // add current to the end
            store.addLast(end);

            // remove from the store the item that is out of the sliding window
            if (start > store.peek()) {
                store.pop();
            }

            // if the window is of the right size, add the head of the store to the result
            // and move the window
            if (end + 1 >= k) {
                result[resultIndex++] = nums[store.peek()];
                start++;
            }

            // move the window
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7}; // k = 3
//        int[] nums = new int[]{7, 2, 4}; // k = 1
//        int[] nums = new int[]{1, -1}; // k = 1
        int[] nums = new int[]{1}; // k = 1
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 1)));
    }
}
