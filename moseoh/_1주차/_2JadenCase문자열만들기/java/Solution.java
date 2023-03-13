package _1주차._2JadenCase문자열만들기.java;

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        String s = "3people unFollowed me  asd  ";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            sb.append(capitalize(st.nextToken()));
        }
        return sb.toString();
    }

    private static String capitalize(String s) {
        if (s.length() < 1) return s;
        else return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
