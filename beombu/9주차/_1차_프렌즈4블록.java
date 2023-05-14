import java.util.LinkedList;
import java.util.List;

/**
 * 1. m이 높이, n이 폭인 2차원 list 생성
 * 2. list의 0 -> 마지막 인덱스 1개전을 돌면서 2x2에 char의 일치를 검증
 * 3. 검증하고 해당 boolean배열에 check
 * 4. 전체 boolean을 돌면서 true인 경우 list에서 remove
 */
public class _1차_프렌즈4블록 {
    List<List<Character>> boards = new LinkedList<>();
    boolean[][] check;

    public static void main(String[] args) {
        int result = new _1차_프렌즈4블록().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        System.out.println(result);
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            boards.add(new LinkedList<>());
            for (int j = 0; j < board[0].length(); j++) {
                boards.get(i).add(board[i].charAt(j));
            }
        }

        while (true) {
            check = new boolean[m][n];
            int cnt = 0;
            for (int a = 0; a < m - 1; a++) {
                for (int b = 0; b < n - 1; b++) {
                    char point = boards.get(a).get(b);

                    if (point == boards.get(a).get(b + 1) && point == boards.get(a + 1).get(b)
                            && point == boards.get(a + 1).get(b + 1)) {
                        check[a][b] = true;
                        check[a][b + 1] = true;
                        check[a + 1][b] = true;
                        check[a + 1][b + 1] = true;
                    }
                }
            }

            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (check[a][b]) {
                        boards.get(a).remove(b);
                        cnt++;
                    }
                }
            }

            if (cnt == 0) {
                break;
            } else {
                answer += cnt;
            }
        }
        return answer;
    }
}
