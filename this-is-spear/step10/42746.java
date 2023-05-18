import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<Node> q = new PriorityQueue<>();

        for (int i : numbers) {
            q.add(new Node(i));
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            sb.append(q.poll().i);
        }

        if (sb.toString().charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }

    private static class Node implements Comparable<Node> {
        private String i;

        public Node(int i) {
            this.i = String.valueOf(i);
        }

        public int compareTo(Node o) {
            return convert(o.i).compareTo(convert(this.i));
        }

        private String convert(String i) {
            return i.repeat(4).substring(0, 4);
        }
    }
}
