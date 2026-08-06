package dsa;

public class InfixPostfixEvaluation {

    // Custom Stack class
    static class Stack {
        private double[] arr;
        private int top;
        private int capacity;

        public Stack(int capacity) {
            this.capacity = capacity;
            arr = new double[capacity];
            top = -1;
        }

        public void push(double value) {
            if (top == capacity - 1) {
                throw new IllegalStateException("Stack is full");
            }
            arr[++top] = value;
        }

        public double pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return arr[top--];
        }

        public double peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return arr[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    // Define operator precedence
    private static final int precedence(char op) {
        switch (op) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    }

    // Convert infix expression to postfix notation
    public static String infixToPostfix(String infix) {
        Stack stack = new Stack(infix.length());
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append((char)stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Pop the '('
                }
            } else { // operator
                while (!stack.isEmpty() && precedence(c) <= precedence((char)stack.peek())) {
                    postfix.append((char)stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append((char)stack.pop());
        }

        return postfix.toString();
    }

    // Evaluate postfix expression
    public static double evaluatePostfix(String postfix) {
        Stack stack = new Stack(postfix.length());

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else { // operator
                double right = stack.pop();
                double left = stack.pop();
                double result;

                switch (c) {
                    case '+': result = left + right; break;
                    case '-': result = left - right; break;
                    case '*': result = left * right; break;
                    case '/': result = left / right; break;
                    default: throw new IllegalArgumentException("Invalid operator: " + c);
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String infix = "2+3*5";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
        double result = evaluatePostfix(postfix);
        System.out.println("Result: " + result);
    }
}
