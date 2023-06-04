package _12주차.두_큐_합_같게_만들기.java;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int[] queue11 = new int[]{3, 2, 7, 2};
        int[] queue21 = new int[]{4, 6, 5, 1};
        int answer1 = 2;
        int result1 = new Solution().solution(queue11, queue21);
        PRINT_RESULT(1, result1, answer1);

        int[] queue12 = new int[]{1, 2, 1, 2};
        int[] queue22 = new int[]{1, 10, 1, 2};
        int answer2 = 7;
        int result2 = new Solution().solution(queue12, queue22);
        PRINT_RESULT(2, result2, answer2);

        int[] queue13 = new int[]{1, 1};
        int[] queue23 = new int[]{1, 5};
        int answer3 = -1;
        int result3 = new Solution().solution(queue13, queue23);
        PRINT_RESULT(3, result3, answer3);
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

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int count = 0;
        int length = (queue1.length + queue2.length) * 2;

        for (int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            sum1 += queue1[i];
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }

        while (sum1 != sum2) {
            count++;
            if (sum1 > sum2) {
                sum1 -= que1.peek();
                sum2 += que1.peek();
                que2.add(que1.poll());
            } else {
                sum1 += que2.peek();
                sum2 -= que2.peek();
                que1.add(que2.poll());
            }
            if (count > length) {
                return -1;
            }
        }

        return count;
    }
}