package com.home.task_044_climbing_stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            cache.put(n, result);
            return result;
        }
    }

    public int climbStairsDP(int n) {
        int one = 1;
        int two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.printf("A: %d, E: %d\n", solution.climbStairs(2), 2);
//        System.out.printf("A: %d, E: %d\n", solution.climbStairs(1), 1);

        System.out.printf("A: %d, E: %d\n", solution.climbStairsDP(2), 2);
        System.out.printf("A: %d, E: %d\n", solution.climbStairsDP(1), 1);
        System.out.printf("A: %d, E: %d\n", solution.climbStairsDP(5), 8);
    }
}
