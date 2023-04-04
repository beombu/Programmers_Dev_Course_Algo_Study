import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char a : s.toCharArray()) {
            queue.offer(a);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                char ch = queue.poll();

                if (stack.isEmpty()) {
                    stack.push(ch);
                } else if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
                queue.offer(ch);
            }

            if (stack.isEmpty()) {
                answer++;
            }

            stack.clear();
            queue.offer(queue.poll());
        }

        return answer;
    }
}
