# Longest Turbulent Subarray

https://leetcode.com/problems/longest-turbulent-subarray/description/

https://youtu.be/V_iHUhR8Dek

### Algorithm
Approach: sliding window (flexible size)

1) We need to check that the sign of equality for each pair of values is alternating
2) We iterate over all elements in the array using a right pointer starting with the second element
3) We compare the element at right pointer to the previous one (get the sign of equality)
4) If the signs are not alternating we shrink the window by moving the left pointer the right - 1 element (the first element of the pair that we were comparing)
5) If the two elements are equal we shrink the window by moving the left pointer to the right element (equal sing should not be included in the alternating sequence)
6) Calculate the size of the window and take the max compared to the previous result

Kadane's algorithm, but a special handling of corner case of equality defines where to move the left pointer.