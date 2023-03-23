import java.util.Stack;

/**
 * Time : O(N)
 * 앞과 뒤가 같은 것을 검증하는 문제는 스택으로 생각하기
 */
public class 짝지어_제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if (arr[i] == stack.peek()) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
