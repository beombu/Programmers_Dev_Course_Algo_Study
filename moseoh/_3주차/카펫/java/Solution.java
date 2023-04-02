package _3주차.카펫.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int brown1 = 10;
        int yellow1 = 2;
        assert Arrays.equals(new Solution().solution(brown1, yellow1), new int[]{4, 3}) : "실패";

        int brown2 = 8;
        int yellow2 = 1;
        assert Arrays.equals(new Solution().solution(brown2, yellow2), new int[]{3, 3}) : "실패";

        int brown3 = 24;
        int yellow3 = 24;
        assert Arrays.equals(new Solution().solution(brown3, yellow3), new int[]{8, 6}) : "실패";
    }

    public int[] solution(int brown, int yellow) {
        int length = brown / 2 + 2;
        int width = length - 1;
        int height = length - width;
        while (brown + yellow != width * height) {
            width--;
            height++;
        }

        return new int[]{width, height};
    }
}
