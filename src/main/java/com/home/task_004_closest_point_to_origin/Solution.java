package com.home.task_004_closest_point_to_origin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] input = {{3,3},{5,-1},{-2,4}};
        int[][] result = s.kClosest(input, 2);
    }

    public int[][] kClosest(int[][] points, int K) {
        Map<Double, List<int[]>> distanceToLocation = new HashMap<>();
        Queue<Double> distancesSorted = new PriorityQueue<>();

        for (int[] location: points) {
            double distance = Math.sqrt(Math.pow(location[0], 2) + Math.pow(location[1], 2));

            if (distanceToLocation.containsKey(distance)) {
                distanceToLocation.get(distance).add(location);
            } else {
                List<int[]> locations = new ArrayList<>();
                locations.add(location);

                distanceToLocation.put(distance, locations);
            }

            distancesSorted.add(distance);
        }

        int[][] result = new int[K][2];
        int i = 0;
        while(!distancesSorted.isEmpty() && i < K) {
            List<int[]> locations = distanceToLocation.get(distancesSorted.poll());

            for (int[] location : locations) {
                result[i++] = location;
            }
        }

        return result;
    }
}
