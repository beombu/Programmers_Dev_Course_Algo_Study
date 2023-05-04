package src.java_algo_stduy.dfs와bfs_문제;

/**
 * 거스름 돈을 가장 적은 수의 동전으로 교환하기
 * 거슬러 줄 동전 최소 갯수
 */
public class _5_다중트리_동전교환 {

    static int coinSize = 3;                //동전 종류 갯수
    static int[] coin = new int[]{1, 2, 5}; //동전 종류
    static int remain = 15;                 //거스름돈

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int sum) {
        if(answer <= depth){
            return;
        }

        if(sum > remain){
            return;
        }

        if (sum == remain) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = coinSize-1; i >=0 ; i--) {
            dfs(depth + 1, sum + coin[i]);
        }
    }
}
