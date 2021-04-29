package com.home.consecutivenumbers;

import java.io.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'consecutive' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER num as parameter.
     */

    public static int consecutive(long num) {
        int count = 0;
        for (int x = 1; x * (x + 1) < 2 * num; x++)
        {
            float a = (float)((1.0 * num -(x * (x + 1)) / 2) / (x + 1));
            if (a - (int)a == 0.0)
                count++;
        }
        return count;
    }

    static void printConsecutive(int last, int first)
    {
        System.out.print(first++);
        for (int x = first; x<= last; x++)
            System.out.print(" + "+x);
    }

    static void findConsecutive(int N)
    {
        for (int last=1; last<N; last++)
        {
            for (int first=0; first<last; first++)
            {
                if (2*N == (last-first)*(last+first+1))
                {
                    System.out.printf(N + " = ");
                    printConsecutive(last, first+1);
                    return;
                }
            }
        }
        System.out.print("-1");
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long num = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.consecutive(num);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}