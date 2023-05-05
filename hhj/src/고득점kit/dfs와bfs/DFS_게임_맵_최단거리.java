package src.고득점kit.dfs와bfs;

//시간초과
public class DFS_게임_맵_최단거리 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    static int answer = Integer.MAX_VALUE;

    public static int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;
        visit = new boolean[n][m];

        dfs(0, 0, 0, n, m, maps);

        return answer == Integer.MAX_VALUE ? -1 : answer+1;
    }

    private static void dfs(int depth,
                            int x,
                            int y,
                            int n,
                            int m,
                            int[][] maps){

        if(x == n && y == m){
            answer = Math.max(depth, answer);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visit[nx][ny]){
                visit[nx][ny] = true;
                dfs(depth + 1, nx, ny, n, m, maps);
                visit[nx][ny] = false;
            }
        }
    }
}
