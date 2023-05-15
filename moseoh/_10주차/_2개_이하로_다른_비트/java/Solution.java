package _10주차._2개_이하로_다른_비트.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        long[] numbers1 = new long[]{2L, 7L};
        long[] answer1 = new long[]{3L, 11L};
        long[] result1 = new Solution().solution(numbers1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, long[] result, long[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }


    /*
    테스트 1 〉	통과 (6.06ms, 75.3MB)
    테스트 2 〉	통과 (8.52ms, 108MB)
    테스트 3 〉	통과 (2.80ms, 79MB)
    테스트 4 〉	통과 (5.94ms, 72.1MB)
    테스트 5 〉	통과 (4.29ms, 82.7MB)
    테스트 6 〉	통과 (3.12ms, 85.5MB)
    테스트 7 〉	통과 (6.69ms, 128MB)
    테스트 8 〉	통과 (6.01ms, 107MB)
    테스트 9 〉	통과 (6.13ms, 123MB)
    테스트 10 〉	통과 (6.37ms, 115MB)
    테스트 11 〉	통과 (6.55ms, 110MB)
     */
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers)
                .map((num) -> (num + 1) + (((num + 1) ^ num) >>> 2))
                .toArray();
    }

    /*
    테스트 1 〉	통과 (6.35ms, 80.8MB)
    테스트 2 〉	통과 (47.75ms, 118MB)
    테스트 3 〉	통과 (2.88ms, 72.2MB)
    테스트 4 〉	통과 (4.39ms, 74.4MB)
    테스트 5 〉	통과 (5.27ms, 80.7MB)
    테스트 6 〉	통과 (5.44ms, 74.7MB)
    테스트 7 〉	통과 (37.90ms, 127MB)
    테스트 8 〉	통과 (36.20ms, 126MB)
    테스트 9 〉	통과 (34.06ms, 121MB)
    테스트 10 〉	통과 (48.56ms, 124MB)
    테스트 11 〉	통과 (51.10ms, 121MB)
    private long getNum(long num) {
        if (num % 2L == 0L) return num + 1;

        String binary = Long.toBinaryString(num);
        if (!binary.contains("0")) return num - (~num >> 1);

        int index = binary.lastIndexOf('0');
        StringBuilder sb = new StringBuilder(binary);
        sb.setCharAt(index, '1');
        sb.setCharAt(index + 1, '0');
        return Long.parseLong(sb.toString(), 2);
    }
     */
}