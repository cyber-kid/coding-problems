package com.home.task_003_change_machine;

import java.util.Arrays;

public class Solution1 {
    public static int coinChange(int[] coins, int amount) {
        int count = 0;

        Arrays.sort(coins);

        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];

            while (amount >= coin) {
                amount -= coin;
                count++;
            }

            if (amount == 0) {
                return count;
            }
        }

        if (amount > 0) {
            return -1;
        } else {
            return count;
        }

    }

    public static void main(String[] args) {
        int result = coinChange(new int[]{186,419,83,408}, 6249);

        System.out.println(result);
    }
}
