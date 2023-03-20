package _2주차._4짝지어제거하기.java;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String s = "baabaa";
        assert new Solution().solution(s) == 1 : "실패";
    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
