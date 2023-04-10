package src._2주차;

import java.util.Stack;

public class 짝지어제거하기 {
    public static int solution(String s) {
        if(s.length() == 0 || s.length()%2==1) {
            return 0;
        }

        if(isString(s)) {
            return 1;
        }

        return 0;
    }

    public static boolean isString(String s){
        Stack<Character> stack = new Stack<>();
        int index = 0;

        stack.push(s.charAt(index++));

        while(index < s.length()){
            char nextChar = s.charAt(index++);

            if(stack.isEmpty()){
                stack.push(nextChar);
            }else if(stack.peek() == nextChar){
                stack.pop();
            }else{
                stack.push(nextChar);
            }
        }

        return stack.isEmpty();
    }
}
