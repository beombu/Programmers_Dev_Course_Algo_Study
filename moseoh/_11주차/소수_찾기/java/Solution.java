package _11주차.소수_찾기.java;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited = new boolean[7];
    int answer = 0;

    public static void main(String[] args) {
        String numbers1 = "17";
        int answer1 = 3;
        int result1 = new Solution().solution(numbers1);
        PRINT_RESULT(1, result1, answer1);

        String numbers2 = "011";
        int answer2 = 2;
        int result2 = new Solution().solution(numbers2);
        PRINT_RESULT(2, result2, answer2);
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

    public int solution(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            getNums(numbers, "", i + 1);
        }

        for (Integer n : set) {
            isPrime(n);
        }

        return answer;
    }

    public void getNums(String numbers, String tmp, int digits) {
        if (digits == tmp.length()) {
            set.add(Integer.parseInt(tmp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp += numbers.charAt(i);
                getNums(numbers, tmp, digits);
                visited[i] = false;
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }

    }

    public void isPrime(int n) {
        if (n == 0)
            return;
        if (n == 1)
            return;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return;
        }
        answer++;
    }
}