package _9주차.모음사전.java;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> list = new ArrayList<>();
    char[] charArray = new char[]{'A', 'E', 'I', 'O', 'U'};

    public static void main(String[] args) {
        String word1 = "AAAAE";
        int answer1 = 6;
        int result1 = new Solution().solution(word1);
        PRINT_RESULT(1, result1, answer1);

        String word2 = "AAAE";
        int answer2 = 10;
        int result2 = new Solution().solution(word2);
        PRINT_RESULT(2, result2, answer2);

        String word3 = "I";
        int answer3 = 1563;
        int result3 = new Solution().solution(word3);
        PRINT_RESULT(3, result3, answer3);

        String word4 = "EIO";
        int answer4 = 1189;
        int result4 = new Solution().solution(word4);
        PRINT_RESULT(4, result4, answer4);
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

    public int solution(String word) {
        stringList("");
        return list.indexOf(word);
    }

    public void stringList(String str) {
        if (str.length() > 5) return;

        list.add(str);

        for (char c : charArray) {
            stringList(str + c);
        }
    }
}