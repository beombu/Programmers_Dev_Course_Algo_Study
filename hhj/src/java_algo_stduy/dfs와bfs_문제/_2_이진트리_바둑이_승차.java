package src.java_algo_stduy.dfs와bfs_문제;

/**
 * 트럭은 네모 킬로그램 넘게 못 태움
 * 가장 무겁게 태울거임
 * N 마리의 바둑이와 가능한 무게 W
 */
public class _2_이진트리_바둑이_승차 {

    static int maxWeight = 259;
    static int size = 5;
    static int[] dogs = new int[]{81, 58, 42, 33, 61};
    static int currentWeight = 0;

    public static void main(String[] args) {
        dfs(0, 0);
        System.out.println(currentWeight);
    }

    public static void dfs(int depth, int sum) {
        if (maxWeight < sum) {
            return;
        }

        if (depth == size) {
            currentWeight = Math.max(currentWeight, sum);
            return;
        }

        dfs(depth + 1, sum+dogs[depth]);
        dfs(depth + 1, sum);
    }
}
