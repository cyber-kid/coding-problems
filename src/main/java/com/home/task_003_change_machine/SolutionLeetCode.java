package com.home.task_003_change_machine;

import java.util.Arrays;

public class SolutionLeetCode {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int []dp = new int [amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 0; i < amount +1; i++){
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                } else {
                    break;
                }
            }
        }

        return (dp[amount] != amount + 1) ? dp[amount]: - 1;
    }

    public static void main(String[] args) {
        int result = coinChange(new int[]{2}, 5);

        System.out.println(result);
    }
}
