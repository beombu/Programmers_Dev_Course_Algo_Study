package _8주차.주식가격.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] prices1 = new int[]{1, 2, 3, 2, 3};
        int[] answer1 = new int[]{4, 3, 1, 1, 0};
        int[] result1 = new Solution().solution(prices1);
        System.out.printf(
                "테스트 케이스 1: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                Arrays.equals(result1, answer1) ? "정답" : "**오답**", Arrays.toString(result1), Arrays.toString(answer1)
        );
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < answer.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) break;
            }
        }

        return answer;
    }
}