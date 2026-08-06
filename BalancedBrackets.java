package dsa;


public class BalancedBrackets {

    public static boolean isBalanced(String expression) {
        int n = expression.length();
        char[] stack = new char[n]; // Array to act as a stack
        int top = -1; // To track the top of the stack

        for (int i = 0; i < n; i++) {
            char ch = expression.charAt(i);

            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack[++top] = ch;
            } 
            // If it's a closing bracket, check for matching opening bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (top == -1) {
                    // No matching opening bracket
                    return false;
                }

                char lastBracket = stack[top--]; // Pop the stack

                // Check if the popped bracket matches the current closing bracket
                if ((ch == ')' && lastBracket != '(') ||
                    (ch == '}' && lastBracket != '{') ||
                    (ch == ']' && lastBracket != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return top == -1;
    }

    public static void main(String[] args) {
        String expression1 = "{[()]}";
        String expression2 = "{[(])}";
        String expression3 = "{{[[(())]]}}";

        System.out.println("Expression: " + expression1 + " is balanced: " + isBalanced(expression1)); // true
        System.out.println("Expression: " + expression2 + " is balanced: " + isBalanced(expression2)); // false
        System.out.println("Expression: " + expression3 + " is balanced: " + isBalanced(expression3)); // true
    }
}
