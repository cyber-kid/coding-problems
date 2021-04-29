package com.home.knapsack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the unboundedKnapsack function below.
    static int unboundedKnapsack(int targetSum, int[] arr) {
        Arrays.sort(arr);

        return knapsackRecursive(targetSum, arr, arr.length - 1);
    }

    private static int knapsackRecursive(int targetSum, int[] arr, int currentIndex) {
        if (currentIndex < 0) {
            return 0;
        }

        int currValue = arr[currentIndex];
        if (targetSum % currValue == 0) {
            return targetSum;
        }

        int x = targetSum / currValue;
        int sum = 0;
        int sum2 = 0;

        if (x > 0) {
            for (int i = 1; i <= x; i++) {
                sum2 = (i * currValue) + knapsackRecursive(targetSum - (i * currValue), arr,
                        currentIndex - 1);
                sum = Math.max(sum, sum2);
            }
        }
        sum2 = knapsackRecursive(targetSum, arr, currentIndex - 1);

        return Math.max(sum, sum2);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < t; j++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }


            int result = unboundedKnapsack(k, arr);

            System.out.println(String.valueOf(result));
        }


        scanner.close();
    }
}

