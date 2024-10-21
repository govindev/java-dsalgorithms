package com.sdesheet.blind;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char openChar = stack.pop();
                if (!arePair(openChar, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean arePair(char openCh, char closeCh) {
        return switch (openCh) {
            case '(' -> closeCh == ')';
            case '{' -> closeCh == '}';
            case '[' -> closeCh == ']';
            default -> false;
        };
    }
}
