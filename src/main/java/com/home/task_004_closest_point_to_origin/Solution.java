package com.home.task_004_closest_point_to_origin;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input = {{3,3},{5,-1},{-2,4}};
        System.out.println(Arrays.deepToString(s.kClosest(input, 2)));
    }

    public int[][] kClosest(int[][] points, int k) {
        int[] distances = new int[points.length];

        for (int i = 0; i < distances.length; i++) {
            int[] pair = points[i];
            distances[i] = getDistance(pair);
        }

        Arrays.sort(distances);

        int distance = distances[k - 1];

        int[][] result = new int[k][2];
        int resultIndex = 0;

        for (int[] point : points) {
            if (getDistance(point) <= distance) {
                result[resultIndex++] = point;
            }
        }

        return result;
    }

    private int getDistance(int[] pair) {
        return pair[0] * pair[0] + pair[1] * pair[1];
    }
}
