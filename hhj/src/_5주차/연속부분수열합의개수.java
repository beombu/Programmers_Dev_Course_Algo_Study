package src._5주차;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {

    /**
     * @param elements : 원형 수열의 모든 원소
     * @return
     */
    public static int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();
        int size = elements.length;

        for (int i = 0; i < size; i++) {

            int sum = 0;
            for (int j = i; j < size + i; j++) {

                sum += elements[j % size];
                set.add(sum);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7, 9, 1, 1, 4};
        System.out.println(solution(arr));
    }
}
