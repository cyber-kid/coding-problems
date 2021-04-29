package com.home.task_002_balaced_brackets;

import java.util.Scanner;
import java.util.Stack;

/*
1
{{}(
 */

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            boolean isOpenBracket = checkIfIsOpenBracket(c);

            if (isOpenBracket) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    // No matching opening bracket
                    return "NO";
                } else if (!checkIfBalancedBreckets(stack.pop(), c)) {
                    // Not balanced pair brackets
                    return "NO";
                }
            }
        }

        // No matching closing bracket
        return stack.isEmpty() ? "YES" : "NO";
    }

    private static boolean checkIfIsOpenBracket(Character c) {
        switch (c) {
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    private static boolean checkIfBalancedBreckets(Character open, Character close) {
        return open.equals('(') && close.equals(')') ||
                open.equals('{') && close.equals('}') ||
                open.equals('[') && close.equals(']');
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
