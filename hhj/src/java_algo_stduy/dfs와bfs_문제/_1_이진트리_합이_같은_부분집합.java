package src.java_algo_stduy.dfs와bfs_문제;

/**
 * N개의 원소로 구성된 자연수 집합
 * 이 집합을 두개의 부분집합으로 나눴을 때,
 * 두 부분집합 원소 합이 서로 같으면 YES / 아니면 NO
 * 둘로 나뉘는 집합은 서로소 집합
 * 두 부분집합을 합치면 원래 집합이 되어야 함
 */
public class _1_이진트리_합이_같은_부분집합 {

    static int[] input1 = new int[]{1, 3, 5, 6, 7, 10};  //YES
    static int[] input2 = new int[]{1, 3, 5, 6, 7, 20};  //YES : 3+5+6+7 = 21 = 20+1
    static int[] input3 = new int[]{1, 3, 5, 6, 7, 22};  //YES

    static int size = 6;

    static boolean flag = false;

    static String answer = "NO";

    static int totalSum = 0;

    public static void main(String[] args) {

        for(int i : input1){
            totalSum += i;
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int sum) {
        if(flag) return;

        if(sum > totalSum/2) return;

        if(depth == size){
            if(totalSum-sum == sum) {
                answer = "YES";
                flag = true;
            }
            return;
        }

        dfs(depth+1, sum + input1[depth]);
        dfs(depth+1, sum);
    }
}
