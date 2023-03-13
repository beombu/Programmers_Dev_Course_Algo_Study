package _1주차._4올바른괄호.java;

import java.util.Stack;

public class Solution {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        for (char c : s.toCharArray()) {
            if (!push(c)) return false;
        }
        return stack.isEmpty();
    }

    public static boolean push(char c) {
        switch (c) {
            case '(' -> stack.push(c);
            case ')' -> {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '(') return false;
                stack.pop();
            }
        }
        return true;
    }

}
