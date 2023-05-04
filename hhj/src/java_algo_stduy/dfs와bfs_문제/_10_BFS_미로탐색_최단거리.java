package src.java_algo_stduy.dfs와bfs_문제;

import java.util.LinkedList;
import java.util.Queue;

public class _10_BFS_미로탐색_최단거리 {

    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        init();
        dis = new int[8][8];
        bfs(1, 1);

        if(dis[7][7] == 0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }

    public static void bfs(int x,
                           int y){

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        board[x][y] = 1;

        while(!queue.isEmpty()){
            Point current = queue.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[current.x][current.y] + 1;
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
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };

        board = new int[8][8];

        for(int i=1; i<8; i++){
            for(int j=1; j<8; j++){
                board[i][j] = values[i - 1][j - 1];
            }
        }
    }
}
