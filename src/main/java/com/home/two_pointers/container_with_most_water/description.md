# Container With Most Water

https://leetcode.com/problems/container-with-most-water/

https://www.youtube.com/watch?v=UuiTKBwPgAo

### Intuition
The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line. Further, the farther the lines, the more will be the area obtained.

### Algorithm
Approach: sliding window

We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. Futher, we maintain a variable maxarea to store the maximum area obtained till now. At every step, we find out the area formed between them, update maxarea and move the pointer pointing to the shorter line towards the other end by one step.

### Time complexity
O(n). We visit each element only once.

### Space complexity
O(1). We use only 2 additional pointers.