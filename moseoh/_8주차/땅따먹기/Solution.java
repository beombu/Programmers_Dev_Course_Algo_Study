package _8주차.땅따먹기;

class Solution {
    int answer = 0;

    public static void main(String[] args) {
        int[][] land1 = new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        int answer1 = 16;
        int result1 = new Solution().solution(land1);
        PRINT_RESULT(1, result1, answer1);
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

    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        System.arraycopy(land[0], 0, dp[0], 0, 4);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j] + getMaxWithOutIndex(j, dp[i - 1]);
            }
        }

        return getMaxWithOutIndex(-1, dp[dp.length - 1]);
    }

    int getMaxWithOutIndex(int index, int[] arr) {
        int num = -1;
        for (int i = 0; i < 4; i++) {
            if (index != i) num = Math.max(num, arr[i]);
        }

        return num;
    }

}