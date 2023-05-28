package _11주차.쿼드압축_후_개수_세기.java;

import java.util.Arrays;

class Solution {
    public final static int ALREADY_COMPRESS = -1;

    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[] answer1 = new int[]{4, 9};
        int[] result1 = new Solution().solution(arr1);
        PRINT_RESULT(1, result1, answer1);

        int[][] arr2 = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
        int[] answer2 = new int[]{10, 15};
        int[] result2 = new Solution().solution(arr2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        int n = arr.length;

        for (int i = n; i > 0; i /= 2) {
            for (int x = 0; x < n; x += i) {
                for (int y = 0; y < n; y += i) {
                    if (canCompress(arr, x, y, i)) {
                        answer[arr[x][y]]++;
                        compress(arr, x, y, i);
                    }
                }
            }
        }

        return answer;
    }

    public boolean canCompress(int[][] arr, int indexX, int indexY, int length) {
        int target = arr[indexX][indexY];
        if (target == ALREADY_COMPRESS) return false;

        for (int x = indexX; x < indexX + length; x++) {
            for (int y = indexY; y < indexY + length; y++) {
                if (arr[x][y] != target) return false;
            }
        }
        return true;
    }

    public void compress(int[][] arr, int indexX, int indexY, int length) {
        for (int x = indexX; x < indexX + length; x++) {
            for (int y = indexY; y < indexY + length; y++) {
                arr[x][y] = ALREADY_COMPRESS;
            }
        }
    }
}