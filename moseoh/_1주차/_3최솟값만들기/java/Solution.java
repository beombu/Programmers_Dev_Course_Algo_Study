package _1주차._3최솟값만들기.java;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(solution(A, B));
    }

//    public static int solution(int[] A, int[] B) {
//        Queue<Integer> queueA = new PriorityQueue<>();
//        Queue<Integer> queueB = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int i = 0; i < A.length; i++) {
//            queueA.add(A[i]);
//            queueB.add(B[i]);
//        }
//
//        int sum = 0;
//        while (!queueA.isEmpty()) {
//            sum += queueA.poll() * queueB.poll();
//        }
//        return sum;
//    }값

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[A.length - i - 1];
        }
        return sum;
    }
}
