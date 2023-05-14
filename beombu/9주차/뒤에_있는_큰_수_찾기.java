import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
    public static void main(String[] args) {
        int[] result = new 뒤에_있는_큰_수_찾기().solution(new int[]{2, 3, 3, 5});
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 0; i < numbers.length; i++) {
            int nowNumber = numbers[i];

            while (!stack.isEmpty() && numbers[stack.peek()] < nowNumber) {
                answer[stack.pop()] = nowNumber;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
