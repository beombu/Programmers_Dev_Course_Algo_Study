public class 게임_맵_최단거리 {
    public static boolean[][] visited;
    static int answer = -1;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        dfs(1,0,0,maps);

        return answer;
    }


    private void dfs(int count, int x, int y, int[][] maps) {
        if (visited[x][y]) {
            return;
        }

        if (x == maps.length - 1 && y == maps[0].length - 1) {
            if (answer == -1) {
                answer = count;
                return;
            }
            answer = Math.min(count, answer);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < visited.length && ny >= 0 && ny < visited[0].length
                    && !visited[nx][ny] && maps[nx][ny] != 0) {
                visited[x][y] = true;
                dfs(count + 1, nx, ny, maps);
                visited[x][y] = false;
            }
        }
    }
}
