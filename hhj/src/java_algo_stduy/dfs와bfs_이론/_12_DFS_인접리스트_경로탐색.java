package src.java_algo_stduy.dfs와bfs_이론;

import java.util.ArrayList;

public class _12_DFS_인접리스트_경로탐색 {

    static ArrayList<ArrayList<Integer>> graph;

    static boolean[] visit;

    static int vEnd = 5;

    static int answer = 0;

    public static void main(String[] args) {
        init();

        visit[1] = true;

        dfs(1);

        System.out.println(answer);
    }

    private static void dfs(int vStart) {
        if (vStart == vEnd) {
            answer++;
            return;
        }

        for (int nv : graph.get(vStart)) {
            if (!visit[nv]) {
                visit[nv] = true;
                dfs(nv);
                visit[nv] = false;
            }
        }
    }

    //방향 그래프
    public static void init() {

        int[][] arr = new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 1},
                {2, 3},
                {2, 5},
                {3, 4},
                {4, 2},
                {4, 5}
        };

        graph = new ArrayList<>();

        for (int i = 0; i < vEnd + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visit = new boolean[vEnd + 1];

        for (int[] edge : arr) {
            int a = edge[0];
            int b = edge[1];
            //방향그래프이기 때문에 한방향만 추가.
            graph.get(a).add(b);
        }
    }
}
