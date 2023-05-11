import java.util.*;

class Solution {
    private static final String X = "X";
    private static final char CHAR = 'X';
    private static final String DELIMETER = ":";

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        while (true) {
            int count = erase(m, n, board);

            if (count == 0) {
                break;
            }

            answer += count;
        }

        return answer;
    }

    private int erase(int m, int n, String[] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m - 1; i++) {
            for (int k = 0; k < n - 1; k++) {
                char one = board[i].charAt(k);
                char two = board[i].charAt(k + 1);
                char three = board[i + 1].charAt(k);
                char four = board[i + 1].charAt(k + 1);
                if (one == two && one == three && one == four) {
                    if (one == CHAR) {
                        continue;
                    }
                    set.add(i + DELIMETER + k);
                    set.add(i + DELIMETER + (k + 1));
                    set.add((i + 1) + DELIMETER + k);
                    set.add((i + 1) + DELIMETER + (k + 1));
                }
            }
        }

        for (String s : set) {
            String[] strs = s.split(DELIMETER);
            int h = Integer.parseInt(strs[0]);
            int w = Integer.parseInt(strs[1]);
            board[h] = replace(board[h], X, w);
        }

        while (sink(m, n, board) != 0) {}

        return set.size();
    }

    private int sink(int m, int n, String[] board) {
        int count = 0;

        for (int w = 0; w < n; w++) {
            for (int h = 0; h < m - 1; h++) {
                char cur = board[h].charAt(w);
                char nxt = board[h + 1].charAt(w);

                if (nxt == CHAR && cur != CHAR) {
                    count += 1;
                    board[h] = replace(board[h], X, w);
                    board[h + 1] = replace(board[h + 1], String.valueOf(cur), w);
                }
            }
        }

        return count;
    }

    private String replace(String ss, String x, int index) {
        return ss.substring(0, index) + x + ss.substring(index + 1);
    }
}
