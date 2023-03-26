package _2주차._2피보나치수.java;

class Solution {
    public static void main(String[] args) {
        int n1 = 3;
        assert new Solution().solution(n1) == 2 : "실패";

        int n2 = 5;
        assert new Solution().solution(n2) == 5 : "실패";
    }

    public int solution(int n) {
        int prev = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current = (prev + temp) % 1234567;
            prev = temp;
        }
        return current;
    }
}
