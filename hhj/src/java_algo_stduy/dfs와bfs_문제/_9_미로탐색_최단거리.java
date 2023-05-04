package src.java_algo_stduy.dfs와bfs_문제;

public class _9_미로탐색_최단거리 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        init();
        board[1][1] = 1;
        dfs(1, 1, 0);
        System.out.println(min);
    }

    public static void dfs(int x,
                           int y,
                           int depth){
        if(depth >= min){
            return;
        }

        if(x == 7 && y == 7){
            min = Math.min(min, depth);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7){
                if(board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    dfs(nx, ny, depth + 1);
                    board[nx][ny] = 0;
                }
            }
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
