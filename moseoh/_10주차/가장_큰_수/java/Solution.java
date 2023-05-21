package _10주차.가장_큰_수.java;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        int[] numbers1 = new int[]{6, 10, 2};
        String answer1 = "6210";
        String result1 = new Solution().solution(numbers1);
        PRINT_RESULT(1, result1, answer1);

        int[] numbers2 = new int[]{3, 30, 34, 5, 9};
        String answer2 = "9534330";
        String result2 = new Solution().solution(numbers2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, String result, String answer) {
        boolean correct = result.equals(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public String solution(int[] numbers) {
        String answer = Arrays.stream(Arrays.stream(numbers).mapToObj(Integer::toString).toArray(String[]::new))
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());
        
        if (Pattern.matches("^0+$", answer)) return "0";
        return answer;
    }
}