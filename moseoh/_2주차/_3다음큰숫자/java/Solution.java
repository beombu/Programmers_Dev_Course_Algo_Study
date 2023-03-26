package _2주차._3다음큰숫자.java;

class Solution {
    public static void main(String[] args) {
        int n1 = 78;
        assert new Solution().solution(n1) == 83 : "실패";

        int n2 = 15;
        assert new Solution().solution(n2) == 23 : "실패";
    }

    public int solution(int n) {
        int count = count(Integer.toBinaryString(n));
        while (true) {
            if (count == count(Integer.toBinaryString(++n))) break;
        }
        return n;
    }

    public int count(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
