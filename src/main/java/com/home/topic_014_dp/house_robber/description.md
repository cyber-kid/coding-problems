# House Robber

https://leetcode.com/problems/house-robber/

https://youtu.be/73r3KWiEvyk

### Algorithm
Dynamic programming (1D)

O(n) space
1) To fill the dp table, we will store the max amount that we can rob until we reach a particular house (a house is an index in the array). 
2) The calculation of the max amount for a particular house will be max(current house + the max for the house that is not a neighbour, the max for the house that is a neighbour) (we decide to rob the current house or skip it)
3) So the value for the particular house (index in the array) will be the max of 2 previous indexes.
4) The value for the last index is the final result.

O(1) space
1) We can also use 2 variables that track the max value for 2 last houses.
2) We init both variables with 0 (to handle the case of 2 first houses)
3) We calculate the value for the current house and store it in temp variable
4) We shift the values in the variables