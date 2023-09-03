# Best Time to Buy and Sell Stock

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

https://youtu.be/1pkOgXD63yU

### Intuition
The array contains values in chronological order - our current value index is always bigger than the lowest value index.

### Algorithm
Approach: Sliding window (flexible size)

1) We need two pointers - one will point to the lowest price, the second will point to the current price.
2) If the current price is lower than the lowest price we update the pointer.
3) To calculate profit we subtract the lowest price from the current price, if it is bigger than the previous result - we update the result.

### Time complexity
O(n). We check all the elements once.

### Space complexity
O(1). Only 2 additional variables are needed.