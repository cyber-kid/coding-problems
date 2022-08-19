package com.home.task_039_prison_cells;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Set<String> store = new HashSet<>();
        boolean hasCycle = false;
        int days = 0;

        for (int i = 0; i < n; i++) {
            int[] next = getNext(cells);
            String cellsStr = Arrays.toString(next);

            if (store.contains(cellsStr)) {
                hasCycle = true;
                break;
            } else {
                store.add(cellsStr);
                days++;
            }

            cells = next;
        }

        if (hasCycle) {
            n = n % days;

            for (int i = 0; i < n; i++) {
                cells = getNext(cells);
            }
        }

        return cells;
    }

    private int[] getNext(int[] cells) {
        int[] result = new int[cells.length];

        for (int i = 0; i < cells.length; i++) {
            if (i == 0 || i == cells.length - 1) {
                result[i] = 0;
            } else {
                result[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] states = new int[]{0,1,0,1,1,0,0,1};
        int[] result = solution.prisonAfterNDays(states, 7);
        System.out.println(Arrays.toString(result));

        states = new int[]{1,0,0,1,0,0,1,0};
        result = solution.prisonAfterNDays(states, 1000000000);
        System.out.println(Arrays.toString(result));
    }
}
