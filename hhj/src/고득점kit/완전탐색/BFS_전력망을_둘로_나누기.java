package src.고득점kit.완전탐색;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_전력망을_둘로_나누기 {

    static int[][] arr;

    /**
     * n개의 송전탑이 하나의 트리 형태로 연결
     * 이 전선들 중 하나를 끊어서 현재 전력망 네트워크를 2개로 분할
     * 이때 두 전력망이 갖게 되는 송전탑 개수를 최대한 비슷하게
     * @param n : 송전탑 갯수
     * @param wires : 전선 정보
     * @return : 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)
     */
    public static int solution(int n,
                               int[][] wires) {

        int answer = n;

        arr = new int[n+1][n+1];

        //먼저 그래프 설정
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];

            arr[start][end] = arr[end][start] = 1;

        }
        
        for(int i=0; i<wires.length; i++){
            int start = wires[i][0];
            int end = wires[i][1];

            arr[start][end] = arr[end][start] = 0;

            answer = Math.min(answer, bfs(n, start));

            arr[start][end] = arr[end][start] = 1;
        }
        
        return answer;
    }

    private static int bfs(int n,
                           int start) {

        boolean[] visit = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int count = 1;

        while (!queue.isEmpty()){
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

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,3},
                {2,3},
                {3,4},
                {4,5},
                {4,6},
                {4,7},
                {7,8},
                {7,9}
        };

        System.out.println(solution(9, arr));
    }
}
