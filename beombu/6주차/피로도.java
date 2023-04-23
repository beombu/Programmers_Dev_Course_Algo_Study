public class 피로도 {
    static boolean[] visited;
    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, dungeons, k);

        return answer;
    }

    public void dfs(int dep, int[][] dungeons, int health) {
        for (int i = 0; i < dungeons.length; i++) {
            //방문 안했고, 체력이 최소 필요 피로도보다 높거나 같을때
            if (!visited[i] && health >= dungeons[i][0]) {
                visited[i] = true;
                dfs(dep + 1, dungeons, health - dungeons[i][1]);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, dep);
    }
}
