package src.고득점kit.dfs와bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_게임_맵_최단거리 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int answer = 0;

    /**
     * ROR 게임은 두 팀으로 나누어서 진행
     * 상대 팀 진영을 먼저 파괴하면 이기는 게임
     * 상대 팀 진영에 도착할 수 없을 때는 -1
     *
     * @param maps : 게임 맵의 상태
     * @return : 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값
     */
    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;
        int[][] dis = new int[n][m];

        bfs(n, m, maps, dis);

        return answer == 0 ? -1 : answer+1;
    }

    private static void bfs(int n,
                            int m,
                            int[][] maps,
                            int[][] dis){

        Queue<Point> queue = new LinkedList<>();
        Point start = new Point(0, 0);
        queue.offer(start);

        while(!queue.isEmpty()){
            Point current = queue.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1){
                    maps[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));

                    dis[nx][ny] = dis[current.x][current.y] + 1;
                }
            }
        }

        answer = dis[n-1][m-1];
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
