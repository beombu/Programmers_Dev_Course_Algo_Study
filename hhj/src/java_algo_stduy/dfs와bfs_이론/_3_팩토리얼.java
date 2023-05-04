package src.java_algo_stduy.dfs와bfs_이론;

public class _3_팩토리얼 {


    public static void main(String[] args) {
        int answer = dfs(5);
        System.out.println(answer);
    }

    static int dfs(int n) {

        if (n == 1) {
            return 1;
        }
        return n * dfs(n - 1);
    }
}
