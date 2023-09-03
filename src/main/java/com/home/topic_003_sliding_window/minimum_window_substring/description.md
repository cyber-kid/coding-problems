# Minimum Window Substring

https://leetcode.com/problems/minimum-window-substring/

https://www.youtube.com/watch?v=jSto0O4AJbM

### Algorithm
1. We start with two pointers, left and right initially pointing to the first element of the string S.
2. We use the right pointer to expand the window until we get a desirable window i.e. a window that contains all the characters of search string.
3. Once we have a window with all the characters, we can move the left pointer ahead one by one. If the window is still a desirable one we keep on updating the minimum window size.
4. If the window is not desirable anymore, we repeat step 2 onwards.