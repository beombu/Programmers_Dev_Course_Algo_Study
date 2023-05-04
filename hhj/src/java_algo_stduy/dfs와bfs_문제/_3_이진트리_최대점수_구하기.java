package src.java_algo_stduy.dfs와bfs_문제;

/**
 * N개의 문제를 풀려고 한다.
 * 각 문제는 해당 문제를 풀었을 때 주는 점수와 시간이 주어짐
 * 제한시간 M안에 N개의 문제 중 최대 점수를 얻어야 함.
 */
public class _3_이진트리_최대점수_구하기 {

    static int size = 5;
    static int time = 20;
    static int[][] arr = new int[][]{
            {10, 5},
            {25, 12},
            {15, 8},
            {6, 3},
            {7, 4}
    };

    static int answer = 0;

    public static void main(String[] args) {

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth,
                           int sumTime,
                           int sumScore) {
        if (time < sumTime) {
            return;
        }

        if (depth == size) {
            answer = Math.max(answer, sumScore);
            return;
        }

        int score = arr[depth][0];
        int time = arr[depth][1];

        dfs(depth + 1, sumTime + time, sumScore + score);
        dfs(depth + 1, sumTime, sumScore);
    }
}
