package _4주차.귤고르기.java;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int k1 = 6;
        int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};
        assert new Solution().solution(k1, tangerine1) == 3 : "실패";

        int k2 = 4;
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};
        assert new Solution().solution(k2, tangerine2) == 2 : "실패";

        int k3 = 2;
        int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};
        assert new Solution().solution(k3, tangerine3) == 1 : "실패";
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            int current = map.getOrDefault(i, 0);
            map.put(i, current + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(map.values());

        int answer = 0;
        int sum = 0;
        while (!queue.isEmpty() && sum < k) {
            sum += queue.poll();
            answer++;
        }

        return answer;
    }
}
