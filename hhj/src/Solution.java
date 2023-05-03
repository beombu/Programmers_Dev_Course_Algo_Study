package src;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] graph;
    static boolean[] visit;
    static int answer = 0;

    static int vEnd = 5;

    public static void main(String[] args) {
        init();
        visit[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int vStart){

        if(vStart == vEnd){
            answer++;
            return;
        }

        for(int i=1; i<=vEnd; i++){
            if(graph[vStart][i] == 1 && !visit[i]){
                visit[i] = true;
                dfs(i);
                visit[i] = false;
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

        visit = new boolean[vEnd+1];
        graph = new int[vEnd+1][vEnd+1];

        for (int[] edge : arr) {
            int a = edge[0];
            int b = edge[1];
            graph[a][b] = 1;
        }
    }
}
