# Longest Substring Without Repeating Characters

https://leetcode.com/problems/longest-substring-without-repeating-characters/

### Intuition
Given a substring with a fixed end index in the string, maintain a HashMap to record the index of each character in the current substring. When we find a repeated char we reduce the substring to this char's index that we take from the hash table.

### Algorithm
Approach: Sliding window

We have 2 pointers - start and current index. We iterate over all chars in the string, store them in a hash table and calculate the length of the substring. If the current char is present in the hash table we point the start pointer to its index and calculate the length.

### Time complexity
O(n). We iterate over all elements once.

### Space complexity 
O(min(m,n)). We need to store all unique chars (m) in the hash table or all chars (n) if they are all unique. 

