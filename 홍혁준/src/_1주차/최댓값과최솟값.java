package src._1주차;

import java.util.*;

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

    public String solution2(String s) {
        int[] ints = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(ints);

        return ints[0] + " " + ints[ints.length-1];
    }
}

