package src.java_algo_stduy.dfs와bfs_문제;

/**
 * N*N의 섬나라 아일랜드의 지도가 격자판으로 주어짐
 * 각 섬은 1로 표시
 * 상하좌우 대각선 모두 연결
 * 0은 바다
 *
 * 몇개의 섬 있는지 체크
 */
public class _12_섬나라_아일랜드 {
    static int size = 7;
    static int[][] values = {
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

    public static void main(String[] args) {

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(values[i][j] == 1){
                    answer++;
                    values[i][j] = 0;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y){

        for(int i=0; i<8; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && nx < size && ny >= 0 && ny < size && values[nx][ny] == 1){
                values[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
}
