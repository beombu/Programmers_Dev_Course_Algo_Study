import java.util.LinkedList;
import java.util.Queue;

public class _3차_n진수_게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int cnt = -1;

        while (t != 0) {
            for (int i = 1; i <= m; i++) {
                if (queue.isEmpty()) {
                    cnt++;
                    for (char ch : Integer.toString(cnt, n).toCharArray()) {
                        queue.add(ch);
                    }
                }

                if (i == p) {
                    sb.append(queue.poll());
                    t--;
                } else {
                    queue.poll();
                }
            }
        }

        return sb.toString().toUpperCase();
    }
}
