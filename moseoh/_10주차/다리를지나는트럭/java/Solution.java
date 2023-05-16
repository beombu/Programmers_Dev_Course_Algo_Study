package _10주차.다리를지나는트럭.java;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int bridge_length1 = 2;
        int weight1 = 10;
        int[] truck_weights1 = new int[]{7, 4, 5, 6};
        int answer1 = 8;
        int result1 = new Solution().solution(bridge_length1, weight1, truck_weights1);
        PRINT_RESULT(1, result1, answer1);

        int bridge_length2 = 100;
        int weight2 = 100;
        int[] truck_weights2 = new int[]{10};
        int answer2 = 101;
        int result2 = new Solution().solution(bridge_length2, weight2, truck_weights2);
        PRINT_RESULT(2, result2, answer2);

        int bridge_length3 = 100;
        int weight3 = 100;
        int[] truck_weights3 = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int answer3 = 110;
        int result3 = new Solution().solution(bridge_length3, weight3, truck_weights3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        // 트럭 개수
        int trucks = truck_weights.length;
        // 트럭 입장시간
        Queue<Integer> truckTime = new LinkedList<Integer>();
        // 현재 다리위 트럭 무게
        int onBridge = 0;
        // 트럭 카운트
        int inputCount = 0;
        int outputCount = 0;

        while (outputCount != trucks) {
            // 입장검사
            if (inputCount < trucks) {
                if (onBridge + truck_weights[inputCount] <= weight) {
                    onBridge += truck_weights[inputCount];
                    inputCount++;
                    truckTime.add(time + bridge_length);
                } else {
                }
            }
            time++;
            // 퇴장검사
            if (truckTime.peek() == time) {
                truckTime.poll();
                onBridge -= truck_weights[outputCount];
                outputCount++;
            }
        }
        return time;
    }
}