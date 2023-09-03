# Fruit Into Baskets

https://leetcode.com/problems/fruit-into-baskets/description/

https://youtu.be/yYtaV0G3mWQ

### Algorithm
Approach: sliding window (fixed size), look up table

1) Look up table will have a fruit type as a key and its occurrences as a value
2) The size of the window will be the amount of the distinct fruit types (two baskets)
3) We iterate over each element (right pointer) and update the look up table (add a new fruit type or increase the occurrence of already existing type)
4) If the size of the look up table is greater than 2 (two baskets) we shrink the window (decrease the occurrences of a fruit type at left pointer or remove the fruit type completely)
5) If the size of the look up table is equal or less than 2 we count the occurrences for all types of fruits and find the max compared to the previous result