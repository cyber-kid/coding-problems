# Product of Array Except Self

https://leetcode.com/problems/product-of-array-except-self/

https://www.youtube.com/watch?v=bNvIQI2wAjk

### Intuition
The given array can be split into halves - before i and after (exclusive). In the answer array at index i we store the product between the elements of both arrays.

### Algorithm
* Initialize the empty answer array where for a given index i, answer[i] would contain the product of all the numbers to the left of i.
* We would need two different loops to fill in values. Because for the 0 element we do not have any elements from the left we will use a **prefix** variable to represent the product of left elements. For element 0 it will be 1, at current iteration we calculate **prefix** that will be used in the next iteration (prefix *= nums[i]).
* We use a variable **postfix** to keep track of the running product of elements to the right and we keep updating the answer array by doing answer[i] = answer[i] * postfix. For a given index i, answer[i] contains the product of all the elements to the left and postfix would contain product of all the elements to the right. We then update postfix as postfix = postfix * nums[i].

### Time Complexity
O(n). We iterate over the input array 2 times - to calculate the product of left items and second time to calculate the product of right items.

### Space complexity
O(1). We use only the answer array.
