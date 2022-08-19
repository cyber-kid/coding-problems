package com.home.task_010_buy_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minIndex = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            }

            result = Math.max(result, prices[i] - prices[minIndex]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.printf("A: %d, E: %d \n", solution.maxProfit(prices), 5);

        prices = new int[]{7,6,4,3,1};
        System.out.printf("A: %d, E: %d \n", solution.maxProfit(prices), 0);
    }
}
