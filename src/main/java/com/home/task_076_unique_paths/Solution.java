package com.home.task_076_unique_paths;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int uniquePaths(int m, int n) {
//        return uniquePathsRec(m, n);

        Map<String, Integer> dp = new HashMap<>();
        return uniquePathsTopDown(m, n, dp);
    }

    private int uniquePathsRec(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }

        if (m <= 0 || n <= 0) {
            return 0;
        }

        return uniquePathsRec(m - 1, n) + uniquePathsRec(m , n - 1);
    }

    private int uniquePathsTopDown(int m, int n, Map<String, Integer> dp) {
        if (dp.containsKey(m + ":" + n)) {
            return dp.get(m + ":" + n);
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        if (m <= 0 || n <= 0) {
            return 0;
        }

        dp.put(m + ":" + n, uniquePathsTopDown(m - 1, n, dp) + uniquePathsTopDown(m , n - 1, dp));
        return dp.get(m + ":" + n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 2)); // 3
        System.out.println(solution.uniquePaths(3, 7)); // 28
    }
}
