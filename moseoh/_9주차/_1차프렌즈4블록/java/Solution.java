package _9주차._1차프렌즈4블록.java;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private final static int[][] D = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    private int answer = 0;

    public static void main(String[] args) {
        int m1 = 4;
        int n1 = 5;
        String[] board1 = new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int answer1 = 14;
        int result1 = new Solution().solution(m1, n1, board1);
        PRINT_RESULT(1, result1, answer1);

        int m2 = 6;
        int n2 = 6;
        String[] board2 = new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int answer2 = 15;
        int result2 = new Solution().solution(m2, n2, board2);
        PRINT_RESULT(2, result2, answer2);

        int m3 = 5;
        int n3 = 6;
        String[] board3 = new String[]{"AAAAAA", "BBAATB", "BBAATB", "JJJTAA", "JJJTAA"};
        int answer3 = 24;
        int result3 = new Solution().solution(m3, n3, board3);
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

    public int solution(int m, int n, String[] board) {
        char[][] array = createArray(m, n, board);

        while (true) {
            List<int[]> removeIndex = findRemoveIndex(array);
            if (removeIndex.isEmpty()) break;
            remove(array, removeIndex);
            fillBlank(array);
        }

        return answer;
    }

    public char[][] createArray(int m, int n, String[] board) {
        char[][] array = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = board[i].charAt(j);
            }
        }
        return array;
    }

    public void remove(char[][] array, List<int[]> removeIndex) {
        for (int[] index : removeIndex) {
            for (int[] ints : D) {
                if (array[index[0] + ints[0]][index[1] + ints[1]] != 'X') {
                    array[index[0] + ints[0]][index[1] + ints[1]] = 'X';
                    answer++;
                }
            }
        }
    }

    public void fillBlank(char[][] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'X') {
                    for (int k = i; k >= 0; k--) {
                        if (array[k][j] != 'X') {
                            array[i][j] = array[k][j];
                            array[k][j] = 'X';
                            break;
                        }
                    }
                }
            }
        }
    }

    public List<int[]> findRemoveIndex(char[][] array) {
        List<int[]> removeIndex = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == 'X') continue;
                if (isRemovable(new int[]{i, j}, array)) {
                    removeIndex.add(new int[]{i, j});
                }
            }
        }
        return removeIndex;
    }

    public boolean isRemovable(int[] index, char[][] array) {
        char findChar = array[index[0]][index[1]];
        for (int[] ints : D) {
            if (array[index[0] + ints[0]][index[1] + ints[1]] != findChar) return false;
        }
        return true;
    }
}