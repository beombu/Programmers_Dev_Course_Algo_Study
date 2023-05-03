/**
 * dp 공부해서 다시 풀기
 */
public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] land1 = new int[][]{{1, 1, 3, 1}, {2, 3, 2, 2}, {1, 4, 1, 1}};
        int[][] land2 = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 3}, {3, 3, 3, 6}, {4, 4, 4, 7}};

        int result = new 땅따먹기().solution(land2);
        System.out.println(result);
    }

    int[][] dp;
    int[][] map;

    int solution(int[][] land) {
        dp = new int[land.length][land[0].length];
        map = land;

        int col = dp.length;
        int row = dp[0].length;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                dp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            recursive(1);
        }

//        for (int i = 0; i < col; i++) {
//            for (int j = 0; j < row; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (max < dp[col - 1][i]) {
                max = dp[col - 1][i];
            }
        }

        return max;
    }

    private void recursive(int colNum) {
        if (colNum == dp.length) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }

                if (dp[colNum][i] < map[colNum][i] + dp[colNum - 1][j]) {
                    dp[colNum][i] = map[colNum][i] + dp[colNum - 1][j];
                }
            }
        }

        recursive(colNum + 1);
    }
}
