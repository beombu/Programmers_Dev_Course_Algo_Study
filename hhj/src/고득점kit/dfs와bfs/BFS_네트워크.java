package src.고득점kit.dfs와bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_네트워크 {

    static boolean[] visit;
    static Queue<Integer> queue = new LinkedList<>();
    static int answer = 0;

    public static int solution(int n,
                               int[][] computers) {

        visit = new boolean[n];

        for (int i=0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                answer++;
                queue.offer(i);
                bfs(n, computers);
            }
        }

        return answer;
    }

    private static void bfs(int n,
                            int[][] computers) {

        while(!queue.isEmpty()){

            int current = queue.poll();

            for(int i=0; i<n; i++){
                if(current != i && computers[current][i] == 1 && !visit[i]){
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(solution(3, arr));
    }
}