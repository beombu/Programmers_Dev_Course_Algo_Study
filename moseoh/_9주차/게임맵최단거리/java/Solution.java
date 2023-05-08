package _9주차.게임맵최단거리.java;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static final int[] DX = {1, 0, -1, 0};
    public static final int[] DY = {0, -1, 0, 1};

    public static void main(String[] args) {
        int[][] maps1 = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int answer1 = 11;
        int result1 = new Solution().solution(maps1);
        PRINT_RESULT(1, result1, answer1);

        int[][] maps2 = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        int answer2 = -1;
        int result2 = new Solution().solution(maps2);
        PRINT_RESULT(2, result2, answer2);
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

    public int solution(int[][] maps) {
        Queue<int[]> que = new LinkedList<>();
        int[] node = {0, 0, 1};
        que.add(node);

        while (!que.isEmpty()) {
            int[] current = que.poll();
            if (!isValid(current[0], current[1], maps)) {
                continue;
            }

            if (current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                return current[2];
            }

            maps[current[0]][current[1]] = 0;

            for (int i = 0; i < DX.length; i++) {
                que.add(new int[]{current[0] + DX[i], current[1] + DY[i], current[2] + 1});
            }
        }

        return -1;
    }

    public boolean isValid(int x, int y, int[][] maps) {
        if (x < 0 || x >= maps.length) return false;
        if (y < 0 || y >= maps[0].length) return false;
        return maps[x][y] != 0;
    }
}