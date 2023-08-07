# Sliding window

Example implementation of fixed size sliding window
```
int left = 0;
// we are iterating over all elements in the array
for (int right = 0; right < array.length; right++) {
    // we are processing the current element

    // when the window is o f required size
    if (right - left + 1 == k) {
        // based on processed elements in the window update the result

        // remove the left element from the window
        // shrink the window by moving the left pointer forward
        left++;
    }
}
// return the result
```

Example implementation of variable size sliding window
```
int result = 0;
int left = 0;
List<Character> store = new ArrayList<>();

// we iterate over all elements in the array
for (int right = 0; right < s.length(); right++) {
    // we are processing the current element
    store.add(s.charAt(right));
    
    // while the condition is not met
    while (store.contains(s.charAt(right))) {
        // remove the element at the left pointer from processed elements
        Character character = s.charAt(left);
        store.remove(character);
        // shrink the window
        left++;
    }

    // update the result
    result = Math.max(result, right - left + 1);
}

return result;
```