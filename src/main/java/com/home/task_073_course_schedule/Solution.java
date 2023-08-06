package com.home.task_073_course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        // count of incoming edges for each vertex
        Map<Integer, Integer> inDegree = new HashMap<>();

        // init
        for (int course = 0; course < numCourses; course++) {
            adjacencyList.put(course, new ArrayList<>());
            inDegree.put(course, 0);
        }

        // populate the adjacency list and count incoming edges for each vertex
        for (int[] prerequisite : prerequisites) {
            adjacencyList.get(prerequisite[0]).add(prerequisite[1]);
            inDegree.merge(prerequisite[1], 1, Integer::sum);
        }

        // find sources (verticies with 0 incoming edges)
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.offer(entry.getKey());
            }
        }

        List<Integer> sortedOrder = new ArrayList<>();
        while (!sources.isEmpty()) {
            int course = sources.poll();
            sortedOrder.add(course);
            for (int prerequisite : adjacencyList.get(course)) {
                inDegree.merge(prerequisite, 1, (oldVal, newVal) -> oldVal - newVal);
                if (inDegree.get(prerequisite) == 0) {
                    sources.offer(prerequisite);
                }
            }
        }

        return sortedOrder.size() == numCourses;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println(solution.canFinish(2, prerequisites)); // true

        prerequisites = new int[][]{{1,0}, {0,1}};
        System.out.println(solution.canFinish(2, prerequisites)); // false
    }
}
