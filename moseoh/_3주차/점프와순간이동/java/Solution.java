package _3주차.점프와순간이동.java;

public class Solution {
    public static void main(String[] args) {
        int N1 = 5;
        assert new Solution().solution(N1) == 2 : "실패";

        int N2 = 6;
        assert new Solution().solution(N2) == 2 : "실패";

        int N3 = 5000;
        assert new Solution().solution(N3) == 5 : "실패";
    }

    public int solution(int n) {
        int ans = 0;
        int num = n;

        while (num != 0) {
            ans = ans + (num % 2);
            num = num / 2;
        }

        return ans;
    }
}
