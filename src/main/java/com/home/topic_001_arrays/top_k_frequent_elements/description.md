# Top K Frequent Elements

https://leetcode.com/problems/top-k-frequent-elements/

https://youtu.be/YPTqKIgVk-k

### Algorithm
Approach: bucket sort, look up table

* We build a look up table using the element and their occurrences.
* We transform the look up table into an array where the index is a number of occurrences and the value is the list of items that occurred that amount of time. The array is of the size n + 1 (0 cell will be always empty).
* We start from the last element of the array (the most occurrences) and take k number of elements. If the list does not have k elements or is empty we go to the previous index.

### Time complexity
O(n). We iterate over the elements once to create a look up table, after that we iterate over the look up table and in worst case it will have n elements, the array that is used to build there result will be also n + 1 and the list in the array will be of size n (if all the values are distinct or the same).

### Space complexity
O(n). Look up table at most will be n, array and lists the same.