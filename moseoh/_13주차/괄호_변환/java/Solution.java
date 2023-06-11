package _13주차.괄호_변환.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String p1 = "(()())()";
        String answer1 = "(()())()";
        String result1 = new Solution().solution(p1);
        PRINT_RESULT(1, result1, answer1);

        String p2 = ")(";
        String answer2 = "()";
        String result2 = new Solution().solution(p2);
        PRINT_RESULT(2, result2, answer2);

        String p3 = "()))((()";
        String answer3 = "()(())()";
        String result3 = new Solution().solution(p3);
        PRINT_RESULT(3, result3, answer3);
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

    public String solution(String p) {
        StringBuilder result = new StringBuilder();
        Queue<Character> v = p.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(LinkedList::new));

        run(v, result);

        return result.toString();
    }

    public void run(Queue<Character> v, StringBuilder result) {
        Queue<Character> u = new LinkedList<>();
        while (!v.isEmpty()) {
            int left = 0;
            int right = 0;

            while (left == 0 || right == 0 || left != right) {
                char c = v.poll();
                u.add(c);

                if (c == '(') left++;
                else right++;
            }

            if (isRightBracket(u)) {
                result.append(queueToString(u));
            } else {
                result.append('(');
                run(v, result);
                result.append(')');
                result.append(queueToString(changeBracket(u)));
            }
        }
    }

    private String queueToString(Queue<Character> chars) {
        StringBuilder result = new StringBuilder();
        while (!chars.isEmpty()) {
            result.append(chars.poll());
        }
        return result.toString();
    }

    private boolean isRightBracket(Queue<Character> chars) {
        int count = 0;
        for (Character c : chars) {
            if (c == '(') count++;
            else count--;

            if (count < 0) return false;
        }

        return count == 0;
    }

    private Queue<Character> changeBracket(Queue<Character> chars) {
        Queue<Character> result = new LinkedList<>();

        Character[] array = chars.toArray(Character[]::new);
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] == '(') result.add(')');
            else result.add('(');
        }

        chars.clear();
        return result;
    }
}
