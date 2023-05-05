package src.고득점kit.dfs와bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_단어변환 {

    static int answer = Integer.MAX_VALUE;
    static Queue<Point> queue = new LinkedList<>();
    static boolean[] visit;
    static int[] dis;

    public static int solution(String begin,
                               String target,
                               String[] words) {

        visit = new boolean[words.length];
        dis = new int[words.length];

        if (Arrays.asList(words).contains(target)) {
            bfs(begin, target, words);
            return answer;
        } else {
            return 0;
        }
    }

    public static void bfs(String begin,
                           String target,
                           String[] words) {
        int level = 0;

        queue.offer(new Point(level, begin));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.word.equals(target)) {
                return;
            }

            for (int i = 0; i < words.length; i++) {
                int check = 0;
                level = point.index;

                String current = point.word;
                String next = words[i];

                if(visit[i]) continue;

                for (int j = 0; j < next.length(); j++) {
                    if (next.charAt(j) != current.charAt(j)) {
                        check++;
                    }

                    if (check > 1) break;
                }

                if(check == 1){
                    visit[i] = true;
                    queue.offer(new Point(i, next));
                    answer = dis[i] = dis[level] + 1;
                }
            }
        }
    }

    public static class Point {
        int index;
        String word;

        public Point(int index, String word) {
            this.index = index;
            this.word = word;
        }
    }

    public static void main(String[] args) {
        String[] arr = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", arr));
    }
}
