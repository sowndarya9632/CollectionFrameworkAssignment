package com.day3;

import java.util.Stack;

public class PostfixEvaluator {

    // Method to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char token : expression.toCharArray()) {
            // If the token is a digit, push it to the stack
            if (Character.isDigit(token)) {
                stack.push(token - '0'); // Convert char to int
            } 
            // If the token is an operator
            else {
                int operand2 = stack.pop(); // Second operand
                int operand1 = stack.pop(); // First operand
                int result = 0;

                switch (token) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                }
                stack.push(result); // Push the result back to the stack
            }
        }
        
        return stack.pop(); // The result is the only element left in the stack
    }

    public static void main(String[] args) {
        String postfixExpression = "23*54*+9-"; // Example: (2 * 3) + (5 * 4) - 9
        int result = evaluatePostfix(postfixExpression);
        
        System.out.println("Postfix Expression: " + postfixExpression);
        System.out.println("Evaluation Result: " + result);
    }
}

