package com.home.task_006_prime_sum;

import com.home.common.maths.MathsUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static List<Integer> primeSum(int n) {
        MathsUtils mathsUtils = new MathsUtils();
        List<Integer> primes = mathsUtils.findPrimesOf(n);

        for (int i = 0; i < primes.size(); i++) {
            int j = n - primes.get(i);
            int result = Collections.binarySearch(primes, j);
            if (result >= 0) {
                ArrayList<Integer> primeSum = new ArrayList<>();
                primeSum.add(primes.get(i));
                primeSum.add(j);

                return primeSum;
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {
        System.out.println(primeSum(4));
    }
}
