package com.home.task_002_valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('}', '{');
        parentheses.put(')', '(');
        parentheses.put(']', '[');

        Stack<Character> store = new Stack<>();

        for (Character item : s.toCharArray()) {
            if (parentheses.containsKey(item)) {
                if (store.isEmpty()) {
                    return false;
                }

                if (store.pop() != parentheses.get(item)) {
                    return false;
                }
            } else {
                store.push(item);
            }
        }

        return store.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("((({[})))"));
    }
}
