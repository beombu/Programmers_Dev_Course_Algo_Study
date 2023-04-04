package _4주차.H_Index.java;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        assert new Solution().solution(citations1) == 3 : "실패";
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for (int i = citations.length - 1; i > -1; i--) {
            int min = Math.min(citations[i], citations.length - i);
            if (max < min) max = min;
        }

        return max;
    }
}