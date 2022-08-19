package com.home.task_049_coin_change;

import java.util.Arrays;

public class Solution {
    int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        backtrack(0, coins, amount);

        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    private void backtrack(int count, int[] coins, int amount) {
        if (amount == 0) {
            result = Math.min(result, count);
            return;
        }

        if (amount < 0) {
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            count++;
            backtrack(count, Arrays.copyOfRange(coins, i, coins.length), amount - coins[i]);

            count--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] coins = new int[] {2};
        System.out.println(solution.coinChange(coins, 3));
    }
}
