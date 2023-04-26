package _7주차.더맵게.java;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int[] scoville1 = new int[]{1, 2, 3, 9, 10, 12};
        int k1 = 7;
        int answer1 = 2;
        int result1 = new Solution().solution(scoville1, k1);
        System.out.printf(
                "테스트 케이스 1: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                result1 == answer1 ? "정답" : "**오답**", result1, answer1
        );
    }

    public int solution(int[] scoville, int K) {
        Queue<Integer> que = new PriorityQueue<>();
        for (int s : scoville) {
            que.add(s);
        }

        int count = 0;
        while (que.peek() < K) {
            if (que.size() == 1) return -1;
            que.add(que.poll() + que.poll() * 2);
            count++;
        }
        
        return count;
    }
}