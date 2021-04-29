package com.home.knapsack;

public class Solution1 {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;

        int result = knapsack(capacity, weights, values, 0);
        System.out.println(result);

        result = knapsackMemorization(capacity, weights, values, 0);
        System.out.println(result);
    }

    private static int knapsack(int capacity, int[] weights, int[] values, int currentItem) {
        if (capacity <= 0 || currentItem == weights.length) {
            return 0;
        }

        int weight = weights[currentItem];
        int profit1 = 0;
        if (weight <= capacity) {
            profit1 = values[currentItem] + knapsack(capacity - weight, weights, values, currentItem + 1);
        }

        int profit2 = knapsack(capacity, weights, values, currentItem + 1);

        return Math.max(profit1, profit2);
    }

    private static int knapsack(int[][] lookUpTable, int capacity, int[] weights, int[] values, int currentItem) {
        if (capacity <= 0 || currentItem == weights.length) {
            return 0;
        }

        if (lookUpTable[currentItem][capacity] >= 0) {
            System.out.println("Cache hit");

            return lookUpTable[currentItem][capacity];
        }

        int weight = weights[currentItem];
        int profit1 = 0;
        if (weight <= capacity) {
            profit1 = values[currentItem] + knapsack(capacity - weight, weights, values, currentItem + 1);
        }

        int profit2 = knapsack(capacity, weights, values, currentItem + 1);

        int maxProfit = Math.max(profit1, profit2);
        lookUpTable[currentItem][capacity] = maxProfit;
        return maxProfit;
    }

    private static int knapsackMemorization(int capacity, int[] weights, int[] values, int currentItem) {
        int[][] lookUpTable = new int[weights.length][capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                lookUpTable[i][j] = -1;
            }
        }

        return knapsack(lookUpTable, capacity, weights, values, currentItem);
    }
}
