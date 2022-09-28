package com.home.task_049_coin_change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;

public class Solution {
    public int coinChange(int[] coins, int amount) {
//        int result = coinChangeRec(coins, amount);

//        Map<Integer, Integer> dp = new HashMap<>();
//        int result = coinChangeTopDown(coins, amount, dp);
//
//        if (result == MAX_VALUE) {
//            return -1;
//        } else {
//            return result;
//        }

        return coinChangeBottomUp(coins, amount);
    }

    private int coinChangeRec(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return MAX_VALUE;
        }

        int count = MAX_VALUE;

        for (int coin : coins) {
            int result = coinChangeRec(coins, amount - coin);
            if (result < count) {
                count = result + 1;
            }
        }

        return count;
    }

    private int coinChangeTopDown(int[] coins, int amount, Map<Integer, Integer> dp) {
        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return MAX_VALUE;
        }

        int count = MAX_VALUE;

        for (int coin : coins) {
            int result = coinChangeTopDown(coins, amount - coin, dp);
            if (result < count) {
                count = result + 1;
            }
        }

        dp.put(amount, count);
        return count;
    }

    private int coinChangeBottomUp(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins = new int[] {1};
        System.out.println(solution.coinChange(coins, 0)); // 0

        coins = new int[] {1, 2, 5};
        System.out.println(solution.coinChange(coins, 11)); //3

        coins = new int[] {2};
        System.out.println(solution.coinChange(coins, 3)); // -1
    }
}
