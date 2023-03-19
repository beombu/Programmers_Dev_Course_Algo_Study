package _1주차._5이진변환반복하기.java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int count = 0;
        int sum = 0;
        while (!s.equals("1")) {
            sum += count(s, '0');
            count++;
            s = Integer.toBinaryString(s.replaceAll("0", "").length());
        }

        return new int[]{count, sum};
    }

    public static int count(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) count++;
        }
        return count;
    }
}
