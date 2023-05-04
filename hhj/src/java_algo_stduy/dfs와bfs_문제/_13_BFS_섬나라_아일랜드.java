package src.java_algo_stduy.dfs와bfs_문제;

import java.util.LinkedList;
import java.util.Queue;

public class _13_BFS_섬나라_아일랜드 {
    static int size = 7;
    static int[][] board = {
            {1, 1, 0, 0, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 0, 0}
    };

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    queue.offer(new Point(i, j));
                    bfs();
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if (nx >= 0 && nx < size && ny >= 0 && ny < size && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
