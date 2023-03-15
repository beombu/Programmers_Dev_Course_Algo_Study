package _1주차;

import java.util.Arrays;

public class 최솟값만들기 {
    public static int solution(int[] A, int[] B) {
        //시간초과
        //Integer[] tempB = Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum += A[i]*B[B.length-i-1];
        }

        return sum;
    }
}