package _1주차;

import java.util.Stack;

public class 올바른괄호 {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(c);
            else if(stack.isEmpty())
                return false;
            else
                stack.pop();
        }

        return stack.isEmpty();
    }
}
