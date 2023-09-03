package com.home.topic_002_two_pointers.reverse_string;

public class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];

            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
//        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[] s = {'h','e','l','l','o'};
        solution.reverseString(s);
    }
}
