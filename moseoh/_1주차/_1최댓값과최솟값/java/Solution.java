package _1주차._1최댓값과최솟값.java;


import java.util.Arrays;

public class Solution {
    public static void main(String[]args){
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        int[] array = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return String.format("%d %d", min, max);
    }
}
