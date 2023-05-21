package _10주차.숫자_변환하기.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int x1 = 10;
        int y1 = 40;
        int n1 = 5;
        int answer1 = 2;
        int result1 = new Solution().solution(x1, y1, n1);
        PRINT_RESULT(1, result1, answer1);

        int x2 = 10;
        int y2 = 40;
        int n2 = 30;
        int answer2 = 1;
        int result2 = new Solution().solution(x2, y2, n2);
        PRINT_RESULT(2, result2, answer2);

        int x3 = 2;
        int y3 = 5;
        int n3 = 4;
        int answer3 = -1;
        int result3 = new Solution().solution(x3, y3, n3);
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

    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, -1);
        dp[x] = 0;
        for (int i = x + 1; i <= y; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0 && dp[i / 3] != -1) min = Math.min(dp[i / 3] + 1, min);
            if (i % 2 == 0 && dp[i / 2] != -1) min = Math.min(dp[i / 2] + 1, min);
            if (i - n >= x && dp[i - n] != -1) min = Math.min(dp[i - n] + 1, min);
            if (min != Integer.MAX_VALUE) dp[i] = min;
        }
        return dp[y];
    }
}