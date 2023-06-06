package _13주차.연속된_부분_수열의_합.java;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] sequence1 = new int[]{1, 2, 3, 4, 5};
        int k1 = 7;
        int[] answer1 = new int[]{2, 3};
        int[] result1 = new Solution().solution(sequence1, k1);
        PRINT_RESULT(1, result1, answer1);

        int[] sequence2 = new int[]{1, 1, 1, 2, 3, 4, 5};
        int k2 = 5;
        int[] answer2 = new int[]{6, 6};
        int[] result2 = new Solution().solution(sequence2, k2);
        PRINT_RESULT(2, result2, answer2);

        int[] sequence3 = new int[]{2, 2, 2, 2, 2};
        int k3 = 6;
        int[] answer3 = new int[]{0, 2};
        int[] result3 = new Solution().solution(sequence3, k3);
        PRINT_RESULT(3, result3, answer3);
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

    public int[] solution(int[] sequence, int k) {
        List<int[]> results = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int startIndex = 0;
        int sum = 0;

        for (int i = 0; i < sequence.length; i++) {
            queue.add(sequence[i]);
            sum += sequence[i];

            while (!queue.isEmpty() && sum > k) {
                startIndex++;
                sum -= queue.poll();
            }

            if (sum == k) {
                results.add(new int[]{startIndex, i});
            }
        }

        results.sort((o1, o2) -> {
            int o1Length = o1[1] - o1[0];
            int o2Length = o2[1] - o2[0];

            if (o1Length == o2Length) {
                return o1[0] - o2[0];
            }
            return o1Length - o2Length;
        });
        return results.get(0);
    }
}