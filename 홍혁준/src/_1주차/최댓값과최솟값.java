package _1주차;

import java.util.StringTokenizer;

public class 최댓값과최솟값 {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;    //최댓값
        int min = Integer.MAX_VALUE;    //최솟값
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ");

        while(stringTokenizer.hasMoreTokens()){
            int value = Integer.parseInt(stringTokenizer.nextToken());

            if(max < value) max = value;
            if (min > value) min = value;
        }

        return min + " " + max;
    }
}

