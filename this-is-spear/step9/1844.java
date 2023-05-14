import java.util.*;

class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, -1, 0, 1 };

    public int solution(int[][] maps) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0, 1 });

        int l = maps.length;
        int w = maps[0].length;

        boolean[][] checked = new boolean[l][w];

        while (!q.isEmpty()) {
            int[] a = q.pollFirst();

            int x = a[0];
            int y = a[1];
            int d = a[2];

            if (y == l - 1 && x == w - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (condition(w, mx)
                    && condition(l, my)) {
                    if (checked[my][mx]) {
                        continue;
                    }

                    if (maps[my][mx] == 0) {
                        continue;
                    }

                    checked[my][mx] = true;
                    q.add(new int[] { mx, my, d + 1 });
                }
            }

        }

        return -1;
    }

    private boolean condition(int i, int a) {
        return 0 <= a && a < i;
    }
}
