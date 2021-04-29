package com.home.prisoncells;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] temp = new int[cells.length];
        System.arraycopy(cells, 0, temp, 0, cells.length);

        while (N-- > 0) {

            temp[0] = 0;
            temp[cells.length - 1] = 0;

            for (int i = 1; i <= cells.length - 2; i++)
                temp[i] = invertState(cells[i - 1], cells[i + 1]);

            System.arraycopy(temp, 0, cells, 0, cells.length);

            System.out.println(Arrays.toString(temp));
        }

        return temp;
    }

    private static int invertState(int i, int state) {
        return i == state ? 1 : 0;
    }
    // METHOD SIGNATURE ENDS

    public static void main(String[] args) {
        int[] states = new int[]{0,1,0,1,1,0,0,1};

        int[] result = prisonAfterNDays(states, 7);

        System.out.println(Arrays.toString(result));
    }
}
