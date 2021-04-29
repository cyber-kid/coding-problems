package com.home.task_003_change_machine;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the ways function below.
    static long ways(int n, List<Long> list) {
        int[] coins = list.stream().mapToInt(Long::intValue).toArray();

        Arrays.sort(coins);

        long[][] lookUpTable = new long[coins.length + 1][n + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= n; j++) {
                lookUpTable[i][j] = -1;
            }
        }

        return waysRecursive(lookUpTable, n, coins, 0, n);
    }

    private static long waysRecursive(long[][] lookUpTable, int n, int[] coins, int currentItem,
            int currentSum) {
        if (n == 0) {
            return 0;
        }

        if (currentItem >= coins.length && currentSum != 0) {
            return 0;
        }

        if (currentSum < 0) {
            return 0;
        }

        if (currentSum == 0) {
            return 1;
        }

        if (lookUpTable[currentItem][currentSum] != -1) {
            return lookUpTable[currentItem][currentSum];
        }

        int currValue = coins[currentItem];
        int x = currentSum / currValue;
        long ways1 = 0;
        long ways2 = 0;

        if (x > 0) {
            for (int i = 1; i <= x; i++) {
                ways2 = waysRecursive(lookUpTable, n, coins, currentItem + 1, currentSum - (i * currValue));
                ways1 += ways2;
            }
        }

        ways2 = waysRecursive(lookUpTable, n, coins, currentItem + 1, currentSum);

        lookUpTable[currentItem][(int)currentSum] = ways1 + ways2;
        return lookUpTable[currentItem][(int)currentSum];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

//        int[] coins = new int[m];

        List<Long> coins = new ArrayList<>();

        String[] coinsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long coinsItem = Long.parseLong(coinsItems[i]);
            coins.add(coinsItem);
        }

        long res = ways(n, coins);

        System.out.println(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
