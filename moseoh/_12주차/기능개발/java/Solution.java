package _12주차.기능개발.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] progresses1 = new int[]{93, 30, 55};
        int[] speeds1 = new int[]{1, 30, 5};
        int[] answer1 = new int[]{2, 1};
        int[] result1 = new Solution().solution(progresses1, speeds1);
        PRINT_RESULT(1, result1, answer1);

        int[] progresses2 = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds2 = new int[]{1, 1, 1, 1, 1, 1};
        int[] answer2 = new int[]{1, 3, 2};
        int[] result2 = new Solution().solution(progresses2, speeds2);
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

    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[101];

        int prev = 0;
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) day++;

            if (i != 0 && prev > day) day = prev;
            days[day]++;
            prev = day;
        }

        return Arrays.stream(days).filter(i -> i != 0).toArray();
    }
}