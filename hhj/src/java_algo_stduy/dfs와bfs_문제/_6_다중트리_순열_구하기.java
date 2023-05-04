package src.java_algo_stduy.dfs와bfs_문제;

/**
 * 10이하의 N개 자연수
 * 이 중 M개를 뽑아 일렬로 나열
 */
public class _6_다중트리_순열_구하기 {
    static int n = 3;   //집합 크기
    static int m = 2;   //뽑을 갯수
    static int[] arr = new int[]{3, 6, 9};  //집합

    static int[] answer = new int[m];
    static boolean[] visit = new boolean[n];

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int depth){

        if(depth == m){
            for(int i=0; i<m; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(!visit[i]) {
                visit[i] = true;
                answer[depth] = arr[i];
                dfs(depth+1);
                visit[i] = false;
            }
        }
    }
}
