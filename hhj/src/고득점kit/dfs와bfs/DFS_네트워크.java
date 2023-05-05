package src.고득점kit.dfs와bfs;

public class DFS_네트워크 {

    static int answer = 0;
    static boolean[] visit;

    /**
     * - 컴퓨터 A, B가 직접적 연결
     * - 컴퓨터 B, C가 직접적 연결
     * - 이는 A와 C가 간접적 연결
     * - 즉, A, B, C 같은 네트워크 상
     *
     * @param n         : 컴퓨터 개수
     * @param computers : 연결에 대한 정보
     * @return : 네트워크 개수
     */
    public static int solution(int n,
                               int[][] computers) {

        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                visit[i] = true;
                dfs(i, n, computers);
            }
        }

        return answer;
    }

    private static void dfs(int i,
                            int n,
                            int[][] computers) {

        for (int j = 0; j < n; j++) {
            if (i != j && computers[i][j] == 1 && !visit[j]) {
                visit[j] = true;
                dfs(j, n, computers);
            }
        }
    }

}