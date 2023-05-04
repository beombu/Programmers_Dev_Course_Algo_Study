package src.java_algo_stduy.dfs와bfs_이론;

//자연수 N이 주어질 때 N 까지의 원소를 갖는 집합의 부분집합
public class _6_DFS_부분집합 {
    static boolean[] visit;
    static int n = 3;

    public static void main(String[] args) {

        visit = new boolean[n];
        dfs(0);
    }

    public static void dfs(int point) {

        if (point == n) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                    stringBuilder.append(i + 1).append(" ");
                }
            }

            if (stringBuilder.toString().length() > 0) {
                System.out.println(stringBuilder);
            }

            return;
        }

        visit[point] = true;
        dfs(point + 1);
        visit[point] = false;
        dfs(point + 1);
    }
}
