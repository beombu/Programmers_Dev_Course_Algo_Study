package src;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] arr;
    public int solution(int n, int[][] wires) {

        int answer = n;

        arr = new int[n+1][n+1];

        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            arr[a][b] = arr[b][a] = 1;
        }

        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            arr[a][b] = arr[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));

            arr[a][b] = arr[b][a] = 1;
        }

        return answer;
    }

    private int bfs(int n, int start) {

        boolean[] visit = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int count = 1;

        while(!queue.isEmpty()){
            int point = queue.poll();

            visit[point] = true;

            for(int i=1; i<=n; i++){
                if(visit[i]) continue;

                if(arr[point][i] == 1){
                    queue.offer(i);
                    count++;
                }
            }
        }

        return Math.abs(n - 2*count);
    }
}
