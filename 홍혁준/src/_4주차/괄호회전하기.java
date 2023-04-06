package src._4주차;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class 괄호회전하기 {

    /**
     * @param s : 대,중,소괄호로 이루어진 문자열
     * @return : s를 왼쪽으로 x만큼 회전 시켰을 때, s가 올바른 괄호 문자열이 되게 하는 x의 개수
     */
    public static int solution(String s) {
        int answer = 0;
        if(s.equals(""))
            return answer;
        Queue<Character> queue = s.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toCollection(LinkedList::new));

        for(int i=0; i<s.length(); i++){

            if(isValid(queueToString(queue))){
                answer++;
            }
            queue.offer(queue.poll());
        }

        return answer;
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                else if(stack.peek()=='(' && c == ')')
                    stack.pop();
                else if(stack.peek() == '{' && c == '}')
                    stack.pop();
                else if(stack.peek() == '[' && c == ']')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static String queueToString(Queue<Character> queue){
        StringBuilder sb = new StringBuilder();
        queue.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("({)}"));
    }
}
