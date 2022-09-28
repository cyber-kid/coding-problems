# Two sum

https://leetcode.com/problems/two-sum/

### Algorithm
Approach: look up table
While we are iterating and inserting elements into the hash table, we also look back to check if current element's complement already exists in the hash table. If it exists, we have found a solution and return the indices immediately.

### Time Complexity
**O(n)**. We traverse the list containing n elements only once. Each lookup in the table costs only O(1) time.

### Space complexity
**O(n)**. The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.