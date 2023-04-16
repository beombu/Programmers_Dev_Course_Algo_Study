package src._4주차;

import java.util.Arrays;

public class H_Index {
    public static int solution(int[] citations) {

        Arrays.sort(citations);

        int remainSize = citations.length + 1;

        for(int i : citations){
            remainSize--;

            if(i >= remainSize){
                return remainSize;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 5};
        int[] b = new int[]{3, 0, 6, 1, 5};
        System.out.println(solution(b));
        System.out.println(solution(a));
    }
}
