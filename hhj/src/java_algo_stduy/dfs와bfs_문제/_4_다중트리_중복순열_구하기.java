package src.java_algo_stduy.dfs와bfs_문제;

/**
 * N까지 번호가 적힌 구슬
 * 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열
 */
public class _4_다중트리_중복순열_구하기 {

    static int n = 3; //구슬 번호
    static int m = 2; //뽑을 횟수

    public static void main(String[] args) {

        int[] answer = new int[m];
        dfs(0, answer);
    }

    public static void dfs(int depth, int[] answer) {

        if(depth == m){
            for(int a : answer){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            answer[depth] = i+1;
            dfs(depth + 1, answer);
        }
    }
}
