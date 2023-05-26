package _11주차.삼각_달팽이;

import java.util.Arrays;

class Solution {

    int[][] array;
    int[][] direction = {{1, 0}, {0, 1}, {-1, -1}};

    public static void main(String[] args) {
        int n1 = 4;
        int[] answer1 = new int[]{1, 2, 9, 3, 10, 8, 4, 5, 6, 7};
        int[] result1 = new Solution().solution(n1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 5;
        int[] answer2 = new int[]{1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9};
        int[] result2 = new Solution().solution(n2);
        PRINT_RESULT(2, result2, answer2);

        int n3 = 6;
        int[] answer3 = new int[]{1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11};
        int[] result3 = new Solution().solution(n3);
        PRINT_RESULT(3, result3, answer3);

        int n4 = 100;
        int[] answer4 = new int[]{1, 2, 3};
        int[] result4 = new Solution().solution(n4);
        PRINT_RESULT(4, result4, answer4);
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

    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        array = new int[n][n];
        fillArray();

        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = array[i][j];
            }
        }
        return answer;
    }

    public void fillArray() {
        int posX = 0;
        int posY = 0;
        int directionIndex = 0;
        int num = 1;

        while (!isValid(posX, posY)) {
            array[posX][posY] = num++;

            posX += direction[directionIndex][0];
            posY += direction[directionIndex][1];

            if (isValid(posX, posY)) {
                posX -= direction[directionIndex][0];
                posY -= direction[directionIndex][1];
                directionIndex = (directionIndex + 1) % direction.length;
                posX = posX + direction[directionIndex][0];
                posY = posY + direction[directionIndex][1];
            }
        }
    }

    public boolean isValid(int posX, int posY) {
        return posX >= array.length || posY >= array.length || posX < 0 || posY < 0 || array[posX][posY] != 0;
    }
}