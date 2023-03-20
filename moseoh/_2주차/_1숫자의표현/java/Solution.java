package _2주차._1숫자의표현.java;

class Solution {
    public static void main(String[] args) {
        int n1 = 15;
        assert new Solution().solution(n1) == 4 : "실패";
    }

    public int solution(int n) {
        int answer = 0;
        int num = 1;
        while (n > 0) {
            if (n % num == 0) answer++;
            n -= num;
            num += 1;
        }
        return answer;
    }
}
