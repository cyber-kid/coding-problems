package com.home.topic_002_two_pointers.boats_to_save_people;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count = 0;

        while (left < right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            count++;
            right--;
        }

        if (left == right) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] people = {1,2}; // 1
        System.out.println(solution.numRescueBoats(people, 3));

        int[] people2 = {3,2,2,1}; // 3
        System.out.println(solution.numRescueBoats(people2, 3));

        int[] people3 = {3,5,3,4}; // 4
        System.out.println(solution.numRescueBoats(people3, 5));
    }
}
