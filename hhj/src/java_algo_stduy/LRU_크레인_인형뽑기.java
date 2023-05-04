package src.java_algo_stduy;

import java.util.*;

public class LRU_크레인_인형뽑기 {

    /**
     * n*n의 정사각 크레인과 오른쪽 바구니 존재
     * 모든 인형은 1*1의 크기로 격자 한 칸을 아래부터 쌓여있음
     * 게임 사용자는 크레인을 좌우로 움직여 가장 위 인형 집어 올림
     * 집어 올린 바구니는 바구니에 쌓임
     * 만약 같은 인형 두개가 연속해서 쌓이면 사라짐
     *
     * @param n1    : 정사각의 크기 (5<=n<=30
     * @param board : 격자의 상태가 담긴 2차원 배열
     * @param n2    : 크레인 동작 횟수
     * @param moves : 크레인의 상태 담긴 1차원 배열
     * @return : 사라진 인형 갯수
     */
    private static int solution(int n1,
                                int[][] board,
                                int n2,
                                int[] moves) {

        List<Queue<Integer>> queueList = new ArrayList<>();

        //정사각 생성
        for (int i = 0; i < n1; i++) {
            Queue<Integer> queue = new LinkedList<>();
            
            for (int j = 0; j < n1; j++) {
                if(board[j][i] != 0){
                    queue.offer(board[j][i]);                    
                }
            }
            queueList.add(queue);
        }

        int answer = 0;

        Stack<Integer> box = new Stack<>();

        for(int i=0; i<n2; i++){
            
            if(queueList.get(moves[i]-1).isEmpty())
                continue;

            if(box.isEmpty()){
                box.push(queueList.get(moves[i]-1).poll());
                continue;
            }

            if(box.peek().equals(queueList.get(moves[i]-1).peek())){
                box.pop();
                answer += 2;
                continue;
            }

            box.push(queueList.get(moves[i]-1).poll());
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] arr1 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] arr2 = new int[]{
                1, 5, 3, 5, 1, 2, 1, 4
        };

        System.out.println(solution(5, arr1, 8, arr2));
    }
}
