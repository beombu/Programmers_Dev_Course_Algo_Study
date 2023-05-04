package src.java_algo_stduy.dfs와bfs_문제;

/**
 * n개의 구슬
 * M개를 뽑자.
 */
public class _7_다중트리_조합구하기 {
    static int n = 4;
    static int m = 2;
    static int[] arr = new int[]{1, 2, 3, 4};

    static int[] answer = new int[m];

    public static void main(String[] args) {
        dfs(0, 0);
    }

    public static void dfs(int depth,
                           int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<n; i++){
            answer[depth] = arr[i];
            dfs(depth +1 , i+1);
        }
    }
}
