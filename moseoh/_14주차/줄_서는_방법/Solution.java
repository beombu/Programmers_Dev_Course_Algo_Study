package _14주차.줄_서는_방법;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int n1 = 3;
        long k1 = 5L;
        int[] answer1 = new int[]{3, 1, 2};
        int[] result1 = new Solution().solution(n1, k1);
        PRINT_RESULT(1, result1, answer1);
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

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long factorial = factorial(n);

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        k--;
        int index = 0;
        while (index < n) {
            factorial /= n - index;
            answer[index++] = list.get((int) (k / factorial));
            list.remove((int) (k / factorial));
            k %= factorial;
        }

        return answer;
    }

    public long factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

}