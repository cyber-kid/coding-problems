package com.home.task_001_binary_representation;

public class Solution {
    public static String findDigitsInBinary(int A) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(A % 2);
            A /= 2;
            if (A == 0) {
                return sb.reverse().toString();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findDigitsInBinary(6));
    }
}
