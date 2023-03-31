package _3주차.N개의최소공배수.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 14};
        assert new Solution().solution(arr1) == 168 : "실패";

        int[] arr2 = {1, 2, 3};
        assert new Solution().solution(arr2) == 6 : "실패";
    }

    public int solution(int[] arr) {
        int answer = 2;
        while (check(arr, answer)) {
            answer++;
        }
        return answer;
    }

    public boolean check(int[] arr, int num) {
        return Arrays.stream(arr).map(i -> num % i).sum() != 0;
    }
}
