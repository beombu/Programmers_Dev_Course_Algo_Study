public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] land1 = new int[][]{{1, 1, 3, 1}, {2, 3, 2, 2}, {1, 4, 1, 1}};
        int[][] land2 = new int[][]{{1, 1, 1, 1}, {2, 2, 2, 3}, {3, 3, 3, 6}, {4, 4, 4, 7}};

        int result = new 땅따먹기().solution(land1);
        System.out.println(result);
    }

    public static boolean[] visited = new boolean[4];

    int solution(int[][] land) {
        return recursive(-1, land, 0);
    }

    private int recursive(int beforeIndex, int[][] land, int depth) {
        int max = Integer.MIN_VALUE;
        int nowIndex = 0;

        if (depth == land.length) {
            return 0;
        }

        if (depth == 0) {
            for (int i = 0; i < land[depth].length; i++) {
                if (max < land[0][i]) {
                    max = land[0][i];
                    nowIndex = i;
                }
            }
            visited[nowIndex] = true;
        } else {
            for (int i = 0; i < land[depth].length; i++) {
                if (!visited[i] && max < land[depth][i]) {
                    max = land[depth][i];
                    nowIndex = i;
                }
            }
            visited[nowIndex] = true;
            visited[beforeIndex] = false;
        }

        System.out.println("max = " + max);

        return max + recursive(nowIndex, land, depth + 1);
    }
}
