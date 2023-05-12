package _9주차.뒤에있는큰수찾기.java;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{2, 3, 3, 5};
        int[] answer1 = new int[]{3, 5, 5, -1};
        int[] result1 = new Solution().solution(numbers1);
        PRINT_RESULT(1, result1, answer1);

        int[] numbers2 = new int[]{9, 1, 5, 3, 6, 2};
        int[] answer2 = new int[]{-1, 5, 6, 6, -1, -1};
        int[] result2 = new Solution().solution(numbers2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = answer.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                answer[i] = stack.peek();
            }
            stack.push(numbers[i]);
        }

        return answer;
    }
}