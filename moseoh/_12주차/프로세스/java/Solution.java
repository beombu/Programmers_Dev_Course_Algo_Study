package _12주차.프로세스.java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int[] priorities1 = new int[]{2, 1, 3, 2};
        int location1 = 2;
        int answer1 = 1;
        int result1 = new Solution().solution(priorities1, location1);
        PRINT_RESULT(1, result1, answer1);

        int[] priorities2 = new int[]{1, 1, 9, 1, 1, 1};
        int location2 = 0;
        int answer2 = 5;
        int result2 = new Solution().solution(priorities2, location2);
        PRINT_RESULT(2, result2, answer2);

        int[] priorities3 = new int[]{1, 1, 1, 1, 1, 1};
        int location3 = 0;
        int answer3 = 1;
        int result3 = new Solution().solution(priorities3, location3);
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

    public int solution(int[] priorities, int location) {
        int count = 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Process> processQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            priorityQueue.add(priorities[i]);
            processQueue.add(new Process(i, priorities[i]));
        }

        while (!processQueue.isEmpty()) {
            if (processQueue.peek().priority != priorityQueue.peek()) {
                processQueue.add(processQueue.poll());
            } else {
                if (processQueue.peek().index == location) {
                    break;
                }
                processQueue.poll();
                priorityQueue.poll();
                count++;
            }
        }

        return count;
    }

    public class Process {
        int index;
        int priority;

        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}