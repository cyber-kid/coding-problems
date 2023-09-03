package com.home.topic_004_stack.min_stack;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        if (stack.empty()) {
            minStack.push(val);
        } else {
            int min = minStack.peek();
            minStack.push(Math.min(min, val));
        }

        stack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack testStack = new MinStack();

        testStack.push(-2);
        testStack.push(0);
        testStack.push(-3);

        System.out.println(testStack.getMin()); // -3

        testStack.pop();

        System.out.println(testStack.top()); // 0
        System.out.println(testStack.getMin()); // -2
    }
}
