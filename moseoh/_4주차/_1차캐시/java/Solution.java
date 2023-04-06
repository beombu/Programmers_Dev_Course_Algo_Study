package _4주차._1차캐시.java;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int cacheSize1 = 3;
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assert new Solution().solution(cacheSize1, cities1) == 50 : "실패";

        int cacheSize2 = 3;
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        assert new Solution().solution(cacheSize2, cities2) == 21 : "실패";

        int cacheSize3 = 2;
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        assert new Solution().solution(cacheSize3, cities3) == 60 : "실패";

        int cacheSize4 = 5;
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        assert new Solution().solution(cacheSize4, cities4) == 52 : "실패";

        int cacheSize5 = 2;
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        assert new Solution().solution(cacheSize5, cities5) == 16 : "실패";

        int cacheSize6 = 0;
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assert new Solution().solution(cacheSize6, cities6) == 25 : "실패";

        int cacheSize7 = 5;
        String[] cities7 = {"a", "b", "c", "a"};
        assert new Solution().solution(cacheSize7, cities7) == 16 : "실패";

        int cacheSize8 = 5;
        String[] cities8 = {"a", "a", "a"};
        assert new Solution().solution(cacheSize8, cities8) == 7 : "실패";

        int cacheSize9 = 3;
        String[] cities9 = {"a", "b", "c", "a"};
        assert new Solution().solution(cacheSize9, cities9) == 16 : "실패";
    }

    public int solution(int cacheSize, String[] cities) {
        System.out.println("\n\n");
        CacheStorage cacheStorage = new CacheStorage(cacheSize);
        int answer = 0;

        for (String s : cities) {
            answer += cacheStorage.get(s);
        }

        System.out.println(answer);
        return answer;
    }

    static class CacheStorage {
        private static final int CACHE_HIT = 1;
        private static final int CACHE_MISS = 5;
        private final int cacheSize;
        private final Queue<String> queue;

        public CacheStorage(int cacheSize) {
            this.cacheSize = cacheSize;
            this.queue = new LinkedList<>();
        }

        public int get(String string) {
            if (cacheSize == 0) return CACHE_MISS;

            String str = string.toLowerCase();
            if (queue.contains(str)) {
                queue.remove(str);
                queue.add(str);
                return CACHE_HIT;
            }

            if (queue.size() >= cacheSize) {
                queue.poll();
            }
            queue.add(str);
            return CACHE_MISS;
        }

    }
}