package src.java_algo_stduy.dfs와bfs_이론;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 송아지찾기
 * - 송아지는 움직이지 않고 제자리에 있다.
 * - 현수는 앞으로 1, 뒤로 1, 앞으로 5 이동 가능
 * - 최소 몇번의 점프로 현수가 송아지의 위치까지 갈 수 있는 지 구하기
 */
public class _8_BFS_상태트리찾기 {

    static int answer = 0;
    static boolean[] visit = new boolean[10001];
    static int[] move = new int[]{-1, 1, 5};
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(bfs(5, 14));
    }

    private static int bfs(int start,
                           int end) {
        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int point = queue.poll();

                for (int m : move) {
                    int nx = point + m;

                    if (nx == end) return answer + 1;

                    if (nx >= 1 && nx <= 10000 && !visit[nx]) {
                        visit[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            answer++;
        }
        return 0;
    }
}
