import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> q = new PriorityQueue<>();

        for (int s : scoville) {
            q.add(s);
        }
        int count = 0;

        while (!q.isEmpty()) {
            int i1 = q.poll();
            if (i1 >= K) {
                return count;
            }

            if (q.isEmpty()) {
                return -1;
            }

            int i2 = q.poll();
            q.add(i1 + i2 * 2);
            count++;
        }

        return -1;
    }
}
