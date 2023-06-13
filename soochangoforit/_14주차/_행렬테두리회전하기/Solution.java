import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length]; // 회전 연산 후의 최소값을 저장할 배열을 초기화
        int[][] matrix = new int[rows][columns]; // 주어진 행과 열로 행렬을 초기화

        // 행렬을 초기화합니다. 각 위치에 해당하는 값을 할당.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }

        // 각 쿼리에 대해 회전 연산을 수행하고 결과적으로 얻은 최소값을 answer 배열에 저장합니다.
        for (int i = 0; i < queries. length; i++) {
            answer[i] = rotate(matrix, queries[i]);
        }

        return answer; // 최소값 배열을 반환합니다.
    }

    /**
     * 모두 원본 배열을 복제하는 배열 없이 구현 시도
     * 
     * 1 시도 : startY,startX 부터 시작해서 endY, endX까지 시계방향으로 움직임
     *        : 원본에 해당하는 복제한 배열을 만들지 않으면, (startY,startX)에 위치하는 값이 모든 회전에 동일하게 적용되는 문제 발생
     *
     * 2 시도 : 시계방향으로 회전을 하더라도, 위쪽변 오른쪽 맨 마지막 index 에 위치하는 값은
     *        : 위쪽변 맨 마지막 index 보다 - 1(한칸) 작은 값으로 할당 시도
     *        : 그러다 보니 각 모서리 값이 회전하면서 중복적으로 할당되는 문제 발생
     *
     * 3 시도 : (정답)
     *        : 회전의 시작점 값을 임시로 저장
     *        : 시계 반대 방향으로 접근하면서 회전
     *        : 시계 반대 방향으로 index를 접근하면서 이전의 값을 할당
     *        : 그러다 보면, 시작점 startY와 startX + 1에 위치하는 값이
     *        : startY+1, startX에 위치하는 값으로 할당되는 문제 발생
     *        : 따라서, 시작점 값을 회전의 끝점(startY,startX+1)에 할당
     */
    public int rotate(int[][] matrix, int[] query) {
        int Y1 = query[0] - 1;
        int X1 = query[1] - 1;
        int Y2 = query[2] - 1;
        int X2 = query[3] - 1;

        // (중요)
        int temp = matrix[Y1][X1]; // 회전의 시작점 값을 임시로 저장

        int min = temp; // 회전 중에 발견된 최소값을 저장

        // 왼쪽 열을 회전
        for (int i = Y1; i < Y2; i++) {
            matrix[i][X1] = matrix[i + 1][X1];
            min = Math.min(min, matrix[i][X1]);
        }

        // 아래쪽 행을 회전
        for (int i = X1; i < X2; i++) {
            matrix[Y2][i] = matrix[Y2][i + 1];
            min = Math.min(min, matrix[Y2][i]);
        }

        // 오른쪽 열을 회전
        for (int i = Y2; i > Y1; i--) {
            matrix[i][X2] = matrix[i - 1][X2];
            min = Math.min(min, matrix[i][X2]);
        }

        // 위쪽 행을 회전
        for (int i = X2; i > X1; i--) {
            matrix[Y1][i] = matrix[Y1][i - 1];
            min = Math.min(min, matrix[Y1][i]);
        }

        // (중요)
        matrix[Y1][X1 + 1] = temp; // 임시로 저장해둔 시작점 값을 회전의 끝점에 할당합니다.

        return min; // 회전 중에 발견된 최소값을 반환
    }
}
