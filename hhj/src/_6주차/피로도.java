package src._6주차;

import java.util.Arrays;

public class 피로도 {

    static int count = 0;

    /**
     * 일정 피로도 사용해 던전 탐험 가능
     * 최소 피로도 : 가지고 있어야할 피로도
     * 소모 피로도 : 탐험 후 소모되는 피로도
     * 하루에 한번 탐험 가능.
     *
     * @param k        : 현재 피로도
     * @param dungeons : 던전별 최소 피로도, 소모 피로도가 담긴 배열
     * @return : 탐험할 수 있는 최대 던전 수
     */
    public static int solution(int k,
                               int[][] dungeons) {

        boolean visited[] = new boolean[dungeons.length];

        Arrays.fill(visited, false);

        dfs(k, dungeons, 0, visited);

        return count;
    }

    private static void dfs(int k,
                           int[][] dungeons,
                           int depth,
                           boolean[] visited) {

        for (int i = 0; i < dungeons.length; i++) {

            if (visited[i] || dungeons[i][0] > k) {
                continue;
            }

            visited[i] = true;

            dfs(k-dungeons[i][1], dungeons, depth+1, visited);

            visited[i] = false;
        }

        count = Math.max(count, depth);
    }

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {80, 20},
                {50, 40},
                {30, 10}
        };

        System.out.println(solution(80, arr));
    }
}
