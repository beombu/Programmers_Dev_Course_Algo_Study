package src.java_algo_stduy.dfs와bfs_문제;

/**
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램
 * 출발점 1, 1
 * 도착점 7, 7
 * 통로 0
 * 벽 1
 */
public class _8_미로탐색 {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) {

        init();
        board[1][1] = 1;
        dfs(1, 1);
        System.out.println(answer);
    }

    public static void dfs(int x,
                           int y){
        if(x == 7 && y == 7){
            answer++;
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=1 && nx <= 7 && ny >= 1 && ny <= 7){
                if(board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    dfs(nx, ny);
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
