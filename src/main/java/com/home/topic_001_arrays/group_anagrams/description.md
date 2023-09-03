# Group Anagrams

https://leetcode.com/problems/group-anagrams/

https://youtu.be/vzdNOK2oB2E

#### Algorithm
Approach: look up table

Maintain a map where each key is a sorted string K, and each value is the list of strings from the initial input that when sorted, are equal to K.

### Time complexity
O(n*k*log(k)). k is the maximum length of the input sting. n the number of input strings. k*log(k) is because of the sorting and we need to sort all n input strings.

### Space complexity
