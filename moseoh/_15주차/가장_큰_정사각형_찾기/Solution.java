package _15주차.가장_큰_정사각형_찾기;

class Solution {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int answer1 = 9;
        int result1 = new Solution().solution(board1);
        PRINT_RESULT(1, result1, answer1);

        int[][] board2 = new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}};
        int answer2 = 4;
        int result2 = new Solution().solution(board2);
        PRINT_RESULT(2, result2, answer2);

        int[][] board3 = new int[][]{{1,}};
        int answer3 = 1;
        int result3 = new Solution().solution(board3);
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

    public int solution(int[][] board) {
        int answer = 0;
        if (board.length == 1 && board[0].length == 1) return board[0][0];

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    board[i][j] = Math.min(
                            Math.min(board[i][j - 1], board[i - 1][j]),
                            board[i - 1][j - 1]
                    ) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }

        return answer * answer;
    }
}