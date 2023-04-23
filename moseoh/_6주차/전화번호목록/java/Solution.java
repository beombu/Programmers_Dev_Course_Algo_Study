package _6주차.전화번호목록.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String[] phone_book1 = new String[]{"119", "97674223", "1195524421"};
        boolean answer1 = false;
        boolean result1 = new Solution().solution(phone_book1);
        System.out.println(result1);
        System.out.println(result1 == answer1 ? "정답" : "오답");

        String[] phone_book2 = new String[]{"123", "456", "789"};
        boolean answer2 = true;
        boolean result2 = new Solution().solution(phone_book2);
        System.out.println(result2);
        System.out.println(result2 == answer2 ? "정답" : "오답");

        String[] phone_book3 = new String[]{"12", "123", "1235", "567", "88"};
        boolean answer3 = false;
        boolean result3 = new Solution().solution(phone_book3);
        System.out.println(result3);
        System.out.println(result3 == answer3 ? "정답" : "오답");
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}