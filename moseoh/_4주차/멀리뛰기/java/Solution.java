package _4주차.멀리뛰기.java;

class Solution {
    int[] dp = new int[2001];

    public static void main(String[] args) {
        int n1 = 4;
        assert new Solution().solution(n1) == 5 : "실패";

        int n2 = 3;
        assert new Solution().solution(n2) == 3 : "실패";
    }

    public long solution(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
