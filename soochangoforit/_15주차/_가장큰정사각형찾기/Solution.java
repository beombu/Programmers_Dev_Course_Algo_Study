class Solution
{
 public int solution(int[][] board)
    {
        // 보드의 차원을 가져옵니다.
        int rows = board.length;
        int cols = board[0].length;
        
        // 이 배열은 위치 (i, j)에서 끝나는 가장 큰 정사각형의 크기를 저장합니다.
        int[][] dp = new int[rows][cols];
        
        // 가장 큰 정사각형의 크기를 추적하기 위한 변수
        int maxSquareSide = 0;
        
        // 보드의 각 셀을 반복합니다.
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                // 첫 번째 행 또는 첫 번째 열이면 보드에서 값을 그대로 복사합니다.
                if(i == 0 || j == 0) {
                    dp[i][j] = board[i][j];
                }
                // 그렇지 않고 셀의 값이 1이면 어떤 정사각형의 오른쪽 하단 모서리입니다.
                else if(board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                // 최대 크기 업데이트
                maxSquareSide = Math.max(maxSquareSide, dp[i][j]);
            }
        }
        
        // 가장 큰 정사각형의 넓이를 반환합니다.
        return maxSquareSide * maxSquareSide;
    }
}