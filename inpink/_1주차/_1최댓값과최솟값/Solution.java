package inpink.java._1주차._1최댓값과최솟값;

import java.util.StringTokenizer;

public class Solution {
    public static void main(String[]args){
        String s = "-1 2 3 4 -1";
        System.out.println(solution(s));
    }

    public static String solution(String s) {

        //데이터 정제
        StringTokenizer st = new StringTokenizer(s);

        int n=st.countTokens();
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        int tmp;
        for (int i=0; i<n; i++) {
            tmp=Integer.parseInt(st.nextToken());
            if (tmp > max) max=tmp;
            if (tmp<min) min=tmp;
        }

        StringBuilder sb= new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }
}


