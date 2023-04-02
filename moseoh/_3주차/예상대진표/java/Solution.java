package _3주차.예상대진표.java;

class Solution {
    public static void main(String[] args) {
        int N1 = 8;
        int A1 = 4;
        int B1 = 7;
        assert new Solution().solution(N1, A1, B1) == 3 : "실패";
    }

    public int solution(int n, int a, int b) {
        int round = 0;
        while ((a - 1) / (int) Math.pow(2, round) != (b - 1) / (int) Math.pow(2, round)) {
            round++;
        }
        return round;
    }
}
