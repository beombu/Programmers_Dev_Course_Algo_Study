package src.java_algo_stduy.dfs와bfs_문제;

import java.util.LinkedList;
import java.util.Queue;

public class _11_BFS_토마토_다시풀기 {
    static int n = 4;
    static int m = 6;
    static int[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] dis = new int[n][m];
    static Queue<Point> queue = new LinkedList<>();
    static int answer = 0;

    public static void main(String[] args) {
        init();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 1)
                    queue.offer(new Point(i, j));
            }
        }

        bfs();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs() {

        while(!queue.isEmpty()){
            Point current = queue.poll();

            for(int i=0; i<4; i++){
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));

                    dis[nx][ny] = dis[current.x][current.y] + 1;
                    answer = Math.max(answer, dis[nx][ny]);
                }
            }
        }
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void init() {

        int[][] values = {
                {0, 0, -1, 0, 0, 0},
                {0, 0, 1, 0, -1, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, 0, 0, -1, 1}
        };

        board = new int[n][m];

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                board[i][j] = values[i][j];
            }
        }
    }
}
