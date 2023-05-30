package _12주차._124_나라의_숫자.java;

class Solution {
    public static void main(String[] args) {
        int n1 = 1;
        String answer1 = "1";
        String result1 = new Solution().solution(n1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 2;
        String answer2 = "2";
        String result2 = new Solution().solution(n2);
        PRINT_RESULT(2, result2, answer2);

        int n3 = 3;
        String answer3 = "4";
        String result3 = new Solution().solution(n3);
        PRINT_RESULT(3, result3, answer3);

        int n4 = 4;
        String answer4 = "11";
        String result4 = new Solution().solution(n4);
        PRINT_RESULT(4, result4, answer4);

        int n5 = 14;
        String answer5 = "112";
        String result5 = new Solution().solution(n5);
        PRINT_RESULT(5, result5, answer5);
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

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n = (n - 1) / 3;
        }
        return sb.reverse().toString().replaceAll("0", "4");
    }
}