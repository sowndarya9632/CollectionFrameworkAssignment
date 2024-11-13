package com.day3;

import java.util.Stack;

public class InfixToPostfix {

    // Method to determine precedence of operators
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3; // Right associative
            default:
                return 0;
        }
    }

    // Method to convert infix to postfix
    public static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (char token : expression.toCharArray()) {
            // If the token is an operand, add it to the output
            if (Character.isLetterOrDigit(token)) {
                output.append(token);
            } 
            // If the token is '(', push it to the stack
            else if (token == '(') {
                stack.push(token);
            } 
            // If the token is ')', pop and output from the stack until '(' is found
            else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop(); // Pop '('
            } 
            // If the token is an operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    output.append(stack.pop());
                }
                stack.push(token);
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "A+B-C*D";
        String postfixExpression = infixToPostfix(infixExpression);
        
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}

