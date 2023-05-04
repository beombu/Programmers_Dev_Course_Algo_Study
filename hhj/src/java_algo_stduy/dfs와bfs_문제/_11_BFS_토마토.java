package src.java_algo_stduy.dfs와bfs_문제;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 보관되는 토마토는 익은 것과 안익은 것 있음
 * 보관 후 하루 지나면 익은 토마토 인접한 토마토도 익은 토마토 영향 받음
 * 대각선은 인접한 것 아님
 * 며칠이 지나야 모든 토마토가 익는지 최소 일수 반환
 * <p>
 * 익은 것 : 1
 * 안익은 것 : 0
 * 토마토 없음 : -1
 * 가로칸 수 : M
 * 세로칸 수 : N
 * <p>
 * 저장될 때부터 모든 토마토가 익은 상태면 0 반환
 * 모두 익지않으면 -1
 */
public class _11_BFS_토마토 {
    static int n = 4;
    static int m = 6;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board, dis;

    static Queue<Point> queue = new LinkedList<>();

    static int answer = 0;

    public static void main(String[] args) {
        init();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 1){
                    queue.offer(new Point(i, j));
                }
            }
        }

        dis = new int[n][m];

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

    public static void bfs() {

        while(!queue.isEmpty()){
            Point current = queue.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[current.x][current.y] + 1;

                    answer = Math.max(dis[nx][ny], answer);
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
