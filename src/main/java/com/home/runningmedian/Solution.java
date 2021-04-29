package com.home.runningmedian;

import java.io.*;
import java.util.*;

public class Solution {

    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
        double[] result = new double[a.length];
        result[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            int newElement = a[i];

            int index = Arrays.binarySearch(a, 0, i, newElement);

            int missingElementIndex = 0;
            if (index < 0) {
                missingElementIndex = (index * -1) - 1;
            } else {
                missingElementIndex = index;
            }

            shiftElements(a, missingElementIndex, i);

            a[missingElementIndex] = newElement;

            boolean hasOddNumberOfElements = (i + 1) % 2 == 1;

            int mid = i / 2;
            if (hasOddNumberOfElements) {
                result[i] = a[mid];
            } else {
                result[i] = (a[mid + 1] + a[mid]) / 2.0;
            }
        }

        return result;
    }

    private static void shiftElements(int[] a, int startIndex, int lastIndex) {
        for (int i = lastIndex; i > startIndex; i--) {
            a[i] = a[i - 1];
        }
    }

    private static int findInsertionIndexForElement(int i, int[] a, int lastIndex) {
        int startIndex = 0;
        int endIndex = lastIndex;
        int midIndex = (endIndex - startIndex) / 2;

        System.out.println("search: " + i);
        System.out.println("start: " + startIndex);
        System.out.println("end: " + endIndex);
        for (int x = 0; x <= lastIndex; x++) {
            System.out.print(a[x] + " ");
        }

        while (startIndex <= endIndex) {
            if (i < a[midIndex]) {
                endIndex = midIndex - 1;
                midIndex = (endIndex - startIndex) / 2;
            } else if (i > a[midIndex]) {
                startIndex = midIndex + 1;
                midIndex = (endIndex - startIndex) / 2;
            } else {
                return midIndex;
            }

        }

        System.out.println();
        System.out.println("index: " + (startIndex + 1));

        return startIndex;
    }

    private static int binarySearch(int key, int[] a, int lastIndex) {
        int low = 0;
        int high = lastIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            System.out.println("mid: " + mid);

            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        // (-(insertion point) - 1)
        return -(low + 1);  // key not found.
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(String.valueOf(result[resultItr]));
        }
    }
}
