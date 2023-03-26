package _2주차._5영어끝말잇기.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int n1 = 3;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        assert Arrays.equals(new Solution().solution(n1, words1), new int[]{3, 3}) : "실패";

        int n2 = 5;
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        assert Arrays.equals(new Solution().solution(n2, words2), new int[]{0, 0}) : "실패";

        int n3 = 2;
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        assert Arrays.equals(new Solution().solution(n3, words3), new int[]{1, 3}) : "실패";
    }

    public int[] solution(int n, String[] words) {
        Set<String> exists = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            if (i != 0) {
                if (exists.contains(words[i]) || words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                    return new int[]{i % n + 1, (i + n) / n};
                }
            }
            exists.add(words[i]);
        }

        return new int[]{0, 0};
    }
}
