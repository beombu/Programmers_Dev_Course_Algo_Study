package _6주차.피로도.java;

class Solution {
    boolean[] isVisited;
    int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int k1 = 80;
        int[][] dungeons1 = new int[][]{new int[]{80, 20}, new int[]{50, 40}, new int[]{30, 10}};
        int answer1 = 3;
        int result1 = new Solution().solution(k1, dungeons1);
        System.out.println(result1);
        System.out.println(result1 == answer1 ? "정답" : "오답");
    }

    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        explorer(k, dungeons, 0, 0);
        return answer;
    }

    public void explorer(int k, int[][] dungeons, int dept, int count) {
        if (dept == dungeons.length) {
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (k >= dungeons[i][0]) {
                    explorer(k - dungeons[i][1], dungeons, dept + 1, count + 1);
                } else {
                    explorer(k, dungeons, dept + 1, count);
                }
                isVisited[i] = false;
            }
        }
    }
}