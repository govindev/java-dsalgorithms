package com.sdesheet.blind;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = (char) stack.peek();
                if (isItCloseOfTop(top, ch)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        return stack.isEmpty();
    }

    private boolean isItCloseOfTop(char top, char curr) {
        return switch (top) {
            case '[' -> curr == ']';
            case '{' -> curr == '}';
            case '(' -> curr == ')';
            default -> false;
        };
    }
}
