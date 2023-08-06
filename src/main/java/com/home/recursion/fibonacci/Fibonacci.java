package com.home.recursion.fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        int result = fibonacciRecursion(5);

        System.out.println("Result is: " + result);

        result = fibonacciRecursionCache(5);

        System.out.println("Result is: " + result);

        result = fibonacciSwap(5);

        System.out.println("Result is: " + result);
    }

    private static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    private static int fibonacciRecursionCache(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int[] cache = new int[n + 1];
        if (cache[n] == 0) {
            cache[n] = fibonacciRecursionCache(n - 1) + fibonacciRecursionCache(n - 2);
            return cache[n];
        } else {
            return cache[n];
        }
    }

    private static int fibonacciSwap(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;

            a = b;
            b = c;
        }

        return c;
    }
}
