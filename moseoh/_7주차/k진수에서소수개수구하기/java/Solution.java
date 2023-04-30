package _7주차.k진수에서소수개수구하기.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n1 = 437674;
        int k1 = 3;
        int answer1 = 3;
        int result1 = new Solution().solution(n1, k1);
        System.out.printf(
                "테스트 케이스 1: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                result1 == answer1 ? "정답" : "**오답**", result1, answer1
        );

        int n2 = 110011;
        int k2 = 10;
        int answer2 = 2;
        int result2 = new Solution().solution(n2, k2);
        System.out.printf(
                "테스트 케이스 2: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                result2 == answer2 ? "정답" : "**오답**", result2, answer2
        );
    }

    public int solution(int n, int k) {
        return (int) Arrays.stream(Integer.toString(n, k).split("0")).filter(this::isPrime).count();
    }

    private boolean isPrime(String str) {
        if (str.isEmpty()) return false;

        long number = Long.parseLong(str);
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
