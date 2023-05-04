package src.java_algo_stduy.dfs와bfs_이론;

public class _14_조합수_메모이제이션 {

    static int n = 33;
    static int r = 19;

    static int[][] answer = new int[10001][10001];

    public static void main(String[] args) {
        System.out.println(dfs(n, r));
    }

    public static int dfs(int n,
                          int r){
        if(answer[n][r] > 0){
            return answer[n][r];
        }

        if(n==r || r==0)
            return answer[n][r] = 1;

        return answer[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }
}
