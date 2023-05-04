package src.java_algo_stduy.dfs와bfs_이론;

public class _4_피보나치_메모이제이션 {

    static int[] answer = new int[11];

    public static void main(String[] args) {
        dfs(10);

        for (int n : answer) {
            System.out.println(n);
        }
    }

    static int dfs(int n) {
        if (answer[n] > 0)
            return answer[n];

        if (n == 1 || n == 2)
            return answer[n] = 1;

        return answer[n] = dfs(n - 1) + dfs(n - 2);
    }
}
