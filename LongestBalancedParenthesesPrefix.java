package dsa;


import java.util.Stack;


public class LongestBalancedParenthesesPrefix {

    public static int longestBalancedPrefix(String s) {
        int n = s.length();
        int[] stack = new int[n]; // Array to act as a stack
        int top = -1; // To track the top of the stack
        int maxLen = 0; // To track the maximum length of balanced prefix

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Push index onto stack
                stack[++top] = i;
            } else if (ch == ')') {
                if (top >= 0) {
                    // Pop the stack
                    top--;
                    if (top >= 0) {
                        // Calculate the current length of the balanced prefix
                        int currentLen = i - stack[top];
                        maxLen = Math.max(maxLen, currentLen);
                    } else {
                        // All are matched from the beginning
                        int currentLen = i + 1;
                        maxLen = Math.max(maxLen, currentLen);
                    }
                } else {
                    // Stack is empty, means unbalanced closing parenthesis
                    break;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "(()())()())";
        int result = longestBalancedPrefix(s);
        System.out.println("Length of longest balanced parentheses prefix: " + result);
    }
}
