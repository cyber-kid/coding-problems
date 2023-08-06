package com.home.sliding_window.best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int sell = 0;

        for (int buy = 1; buy < prices.length; buy++) {
            result = Math.max(result, prices[buy] - prices[sell]);

            if (prices[buy] < prices[sell]) {
                sell = buy;
            }
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
