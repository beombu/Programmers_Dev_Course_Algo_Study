import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for(int i = 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }

        for(int i = 1; i < arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }

        for(int num: arrayB){
            if(num % gcdA == 0){
                gcdA = 0;
                break;
            }
        }

        for(int num: arrayA){
            if(num % gcdB == 0){
                gcdB = 0;
                break;
            }
        }

        return Math.max(gcdA, gcdB);
    }

    public int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
