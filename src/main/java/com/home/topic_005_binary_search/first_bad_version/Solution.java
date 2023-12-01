package com.home.topic_005_binary_search.first_bad_version;

public class Solution {
    private int badVersion;
    public int firstBadVersion(int n) {
        int currentBadVersion = 0;
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                currentBadVersion = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return currentBadVersion;
    }

    public void setBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }
    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.setBadVersion(5);
        System.out.println(solution.firstBadVersion(7)); // 5

        solution.setBadVersion(1);
        System.out.println(solution.firstBadVersion(1)); // 1
    }
}
