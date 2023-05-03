package src.고득점kit.완전탐색;

public class DFS_전력망을_둘로_나누기 {

    static int min;
    static int[][] map;
    static boolean[] visit;

    public static int solution(int n, int[][] wires){
        min = n;
        map = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int[] wire : wires){
            int start = wire[0];
            int end = wire[1];

            map[start][end] = map[end][start] = 1;
        }

        dfs(n, 1);

        return min;
    }

    public static int dfs(int n, int point){

        visit[point] = true;

        int count = 1;

        for(int i=1; i<n; i++){
            if(!visit[i] && map[point][i] == 1){
                count += dfs(n, i);
            }
        }

        min = Math.min(min, Math.abs(count - (n-count)));

        return count;
    }
}
