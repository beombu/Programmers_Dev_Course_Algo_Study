package src.java_algo_stduy.dfs와bfs_이론;

public class _2_이진수출력 {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        dfs(11);
        System.out.println(stringBuilder.reverse().toString());
    }

    static void dfs(int n) {

        if (n == 0) {
            return;
        }

        stringBuilder.append(n % 2);
        dfs(n / 2);
    }
}
