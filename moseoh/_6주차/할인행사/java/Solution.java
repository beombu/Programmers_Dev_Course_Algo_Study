package _6주차.할인행사.java;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        String[] want1 = new String[]{"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = new int[]{3, 2, 2, 2, 1};
        String[] discount1 = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int answer1 = 3;
        int result1 = new Solution().solution(want1, number1, discount1);
        System.out.println(result1);
        System.out.println(result1 == answer1 ? "정답" : "오답");

        String[] want2 = new String[]{"apple"};
        int[] number2 = new int[]{10};
        String[] discount2 = new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        int answer2 = 0;
        int result2 = new Solution().solution(want2, number2, discount2);
        System.out.println(result2);
        System.out.println(result2 == answer2 ? "정답" : "오답");
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Queue<String> discountQue = new LinkedList<>();
        for (String discountItem : discount) {
            discountQue.add(discountItem);
            if (discountQue.size() < 10) continue;

            boolean isMemberShip = true;
            for (int i = 0; i < want.length; i++) {
                if (!isMemberShip) break;
                String wantItem = want[i];
                isMemberShip = discountQue.stream().filter((it) -> it.equals(wantItem)).count() == number[i];
            }
            if (isMemberShip) answer++;
            discountQue.poll();
        }
        return answer;
    }
}