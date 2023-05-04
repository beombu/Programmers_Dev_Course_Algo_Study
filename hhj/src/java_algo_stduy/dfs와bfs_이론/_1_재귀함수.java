package src.java_algo_stduy.dfs와bfs_이론;

public class _1_재귀함수 {

    public static void main(String[] args) {
        dfs(3);
    }

    public static void dfs(int n) {

        if (n == 0)
            return;

        System.out.println(n);

        dfs(n - 1);
    }
}
