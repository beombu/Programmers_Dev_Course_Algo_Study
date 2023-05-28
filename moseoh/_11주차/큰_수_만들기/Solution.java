package _11주차.큰_수_만들기;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String number1 = "1924";
        int k1 = 2;
        String answer1 = "94";
        String result1 = new Solution().solution(number1, k1);
        PRINT_RESULT(1, result1, answer1);

        String number2 = "1231234";
        int k2 = 3;
        String answer2 = "3234";
        String result2 = new Solution().solution(number2, k2);
        PRINT_RESULT(2, result2, answer2);

        String number3 = "4177252841";
        int k3 = 4;
        String answer3 = "775841";
        String result3 = new Solution().solution(number3, k3);
        PRINT_RESULT(3, result3, answer3);

        String number4 = "111111";
        int k4 = 4;
        String answer4 = "11";
        String result4 = new Solution().solution(number4, k4);
        PRINT_RESULT(4, result4, answer4);

//        String number5 = "54321";
//        int k5 = 3;
//        String answer5 = "54";
//        String result5 = new Solution().solution(number5, k5);
//        PRINT_RESULT(5, result5, answer5);

        String number6 = "1251521";
        int k6 = 4;
        String answer6 = "552";
        String result6 = new Solution().solution(number6, k6);
        PRINT_RESULT(6, result6, answer6);
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

    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int removeCount = k;
        for (int i = 0; i < number.length(); i++) {
            int num = Character.getNumericValue(number.charAt(i));
            while (!stack.isEmpty() && stack.peek() < num && removeCount-- > 0) {
                stack.pop();
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().substring(0, number.length() - k);
    }

}