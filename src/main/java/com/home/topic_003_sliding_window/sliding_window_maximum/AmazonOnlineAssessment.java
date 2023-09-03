package com.home.topic_003_sliding_window.sliding_window_maximum;

// Give you a list servers. Their processing power is given as a array of integer, and boot power as a array of integer.
// Write a function to return the max length of sub array which's power consumption is less than or equal to max power limit.
// Formula to calculate the power consumption for a subArray is:
// Max(bootPower[i...j]) + Sum(processPower[i....j]) * length of subArray.
//
// Note: Single server is also a subArray, return 0 if no such subArray can be found.

import java.util.PriorityQueue;

public class AmazonOnlineAssessment {
    public int maxLengthValidSubArray(int[] processingPower, int[] bootingPower, int maxPower) {
        PriorityQueue<Integer> maxBootingPower = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int result = 0;
        int currentSumProcessingPower = 0;

        int start = 0;
        int end = 0;

        while (end < processingPower.length) {
            currentSumProcessingPower += processingPower[end];
            maxBootingPower.add(bootingPower[end]);

            int powerConsumption = maxBootingPower.peek() + currentSumProcessingPower * (end - start + 1);

            if (powerConsumption > maxPower) {
                currentSumProcessingPower -= processingPower[start];
                maxBootingPower.remove(processingPower[start]);

                start++;
            } else {
                result = Math.max(result, end - start + 1);
            }

            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        AmazonOnlineAssessment solution = new AmazonOnlineAssessment();

        int[] bootingPower = new int[]{2, 1, 4, 6, 1};
        int[] processingPower = new int[]{9, 14, 8, 15, 15};
        int maxPower = 36;

        System.out.println(solution.maxLengthValidSubArray(processingPower, bootingPower, maxPower));
    }
}
