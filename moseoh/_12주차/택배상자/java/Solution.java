package _12주차.택배상자.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        int[] order1 = new int[]{4, 3, 1, 2, 5};
        int answer1 = 2;
        int result1 = new Solution().solution(order1);
        PRINT_RESULT(1, result1, answer1);

        int[] order2 = new int[]{5, 4, 3, 2, 1};
        int answer2 = 5;
        int result2 = new Solution().solution(order2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(int[] order) {
        Queue<Integer> container = getContainer(order.length);
        Stack<Integer> subContainer = new Stack<>();

        for (int current : order) {
            if (!subContainer.isEmpty() && subContainer.peek() == current) {
                subContainer.pop();
                continue;
            }

            while (!container.isEmpty() && container.peek() != current) {
                subContainer.push(container.poll());
            }
            if (!container.isEmpty() && container.peek() == current) {
                container.poll();
                continue;
            }

            break;
        }

        return order.length - container.size() - subContainer.size();
    }

    public Queue<Integer> getContainer(int n) {
        Queue<Integer> container = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            container.add(i);
        }
        return container;
    }
}