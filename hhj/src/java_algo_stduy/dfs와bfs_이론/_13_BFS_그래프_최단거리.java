package src.java_algo_stduy.dfs와bfs_이론;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _13_BFS_그래프_최단거리 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static int vertexSize = 7;

    static boolean[] visit = new boolean[vertexSize];

    //1번 정점에서 각 정점으로가는 최소 이동 간선수
    static int[] answer = new int[vertexSize];


    public static void main(String[] args) {
        init();

        bfs(1);

        for(int i=2; i<vertexSize; i++){
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int vStart) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(vStart);

        visit[vStart] = true;

        answer[vStart] = 0;

        while(!queue.isEmpty()){

            int currentV = queue.poll();

            for(int nv : graph.get(currentV)){
                if(!visit[nv]){
                    visit[nv] = true;
                    queue.offer(nv);
                    answer[nv] = answer[currentV] + 1;
                }
            }
        }
    }

    public static void init() {

        int[][] arr = new int[][]{
                {1, 3},
                {1, 4},
                {2, 1},
                {2, 5},
                {3, 4},
                {4, 5},
                {4, 6},
                {6, 2},
                {6, 5}
        };

        for (int i = 0; i < vertexSize; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : arr) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
        }
    }
}
