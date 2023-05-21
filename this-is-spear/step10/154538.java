import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] checked = new boolean[y + 1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        Node now = new Node(0, x);
        q.add(now);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.x > y) {
                continue;
            }

            if (checked[cur.x]) {
                continue;
            }

            checked[cur.x] = true;

            if (cur.x == y) {
                return cur.count;
            }

            if (cur.x < y) {
                q.add(new Node(cur.count + 1, cur.x * 3));
                q.add(new Node(cur.count + 1, cur.x * 2));
                q.add(new Node(cur.count + 1, cur.x + n));
            }
        }

        return -1;
    }

    private static class Node implements Comparable<Node> {
        int count;
        int x;

        public Node(int count, int x) {
            this.count = count;
            this.x = x;
        }

        public int compareTo(Node n) {
            return this.count - n.count;
        }
    }
}
