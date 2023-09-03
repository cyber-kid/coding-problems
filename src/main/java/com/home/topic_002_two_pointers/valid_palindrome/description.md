# Valid Palindrome

https://leetcode.com/problems/valid-palindrome/

### Algorithm
Approach: two pointers

* Set two pointers, one at each end of the input string
* If the input is palindromic, both the pointers should point to equivalent characters, at all times.
* If this condition is not met at any point of time, we break and return early.
* We can simply ignore non-alphanumeric characters by continuing to traverse further.
* Continue traversing inwards until the pointers meet in the middle.

### Time complexity
O(n). We visit each element only once

### Space complexity
O(1). We do not need extra space

### Option 2
Requires O(n) space. We'll reverse the given string and compare it with the original. If those are equivalent, it's a palindrome.