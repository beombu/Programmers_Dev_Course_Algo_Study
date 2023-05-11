import java.util.LinkedList;
import java.util.List;

public class _1차_프렌즈4블록 {
    List<List<Character>> boards = new LinkedList<>();

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
            int cnt = 0;
            for (int a = 0; a < m - 1; a++) {
                for (int b = 0; b < n - 1; b++) {
                    if (boards.get(a).get(b) == '0') {
                        continue;
                    }
                    char point = boards.get(a).get(b);

                    if (point == boards.get(a).get(b + 1) && point == boards.get(a + 1).get(b)
                            && point == boards.get(a + 1).get(b + 1)) {
                        boards.get(a).set(b, '0');
                        boards.get(a + 1).set(b, '0');
                        boards.get(a + 1).set(b + 1, '0');
                        boards.get(a).set(b + 1, '0');
                    }

                }
            }

            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if (boards.get(a).get(b) == '0') {
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
