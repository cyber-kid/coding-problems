package com.home.gcd;

public class Solution {
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int generalizedGCD(int n, int arr[]) {
        int result = 0;
        for (int element: arr){
            result = gcd(result, element);

            if(result == 1)
            {
                return 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int result = generalizedGCD(5, new int[]{2, 3, 4, 5, 6});

        System.out.println(result);
    }
}
