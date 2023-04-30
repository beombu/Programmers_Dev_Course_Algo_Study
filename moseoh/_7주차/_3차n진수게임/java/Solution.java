package _7주차._3차n진수게임.java;

class Solution {
    public static void main(String[] args) {
        int n1 = 2;
        int t1 = 4;
        int m1 = 2;
        int p1 = 1;
        String answer1 = "0111";
        String result1 = new Solution().solution(n1, t1, m1, p1);
        System.out.printf(
                "테스트 케이스 1: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                result1.equals(answer1) ? "정답" : "**오답**", result1, answer1
        );

        int n2 = 16;
        int t2 = 16;
        int m2 = 2;
        int p2 = 1;
        String answer2 = "02468ACE11111111";
        String result2 = new Solution().solution(n2, t2, m2, p2);
        System.out.printf(
                "테스트 케이스 2: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                result2.equals(answer2) ? "정답" : "**오답**", result2, answer2
        );

        int n3 = 16;
        int t3 = 16;
        int m3 = 2;
        int p3 = 2;
        String answer3 = "13579BDF01234567";
        String result3 = new Solution().solution(n3, t3, m3, p3);
        System.out.printf(
                "테스트 케이스 3: %s\n" +
                        "\t- 실행 결과: %s\n" +
                        "\t- 기댓값: %s\n\n",
                result3.equals(answer3) ? "정답" : "**오답**", result3, answer3
        );
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i <= m * t; i++) {
            number.append(Integer.toString(i, n).toUpperCase());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            result.append(number.charAt(i * m + p - 1));
        }

        return result.toString();
    }
}