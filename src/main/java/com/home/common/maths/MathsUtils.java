package com.home.common.maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathsUtils {
    public List<Integer> findPrimesOf(int n) {
        List<Integer> result = new ArrayList<>();

        int[] primes = new int[n + 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = 1;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] == 1) {
                for (int j = 2; j * i <= n; j++) {
                    primes[i * j] = 0;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 1) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findAllFactorsOf(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result.add(i);
                if (n / i != Math.sqrt(n)) {
                    result.add(n / i);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
