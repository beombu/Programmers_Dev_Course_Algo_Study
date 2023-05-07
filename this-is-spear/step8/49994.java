import java.util.*;

class Solution {
    // y, x
    private static final Node L = new Node(-1, 0, 'L');
    private static final Node R = new Node(1, 0, 'R');
    private static final Node U = new Node(0, 1, 'U');
    private static final Node D = new Node(0, -1, 'D');

    public int solution(String dirs) {
        Map<Character, Node> dir = initializeMap();
        Set<Node> set = new HashSet<>();
        Node cur = new Node(0, 0, 'M');
        for (int i = 0; i < dirs.length(); i++) {
            Node a = dir.get(dirs.charAt(i));
            if (condition(cur, a)) {
                Node t = new Node(cur.x, cur.y, a.c);
                set.add(t);
                set.add(t.inverse());
                cur = cur.go(a);
            }
        }
        return set.size() / 2;
    }

    private Map<Character, Node> initializeMap() {
        Map<Character, Node> dir = new HashMap<>();
        dir.put('L', L);
        dir.put('R', R);
        dir.put('U', U);
        dir.put('D', D);
        return dir;
    }

    private boolean condition(Node n1, Node n2) {
        return -5 <= n1.x + n2.x && n1.x + n2.x <= 5 && -5 <= n1.y + n2.y && n1.y + n2.y <= 5;
    }

    private static class Node {
        private int x;
        private int y;
        private char c;

        public Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        public Node go(Node n) {
            return new Node(this.x + n.x, this.y + n.y, 'M');
        }

        public Node inverse() {
            if (this.c == 'L') {
                return new Node(this.x - 1, this.y, 'R');
            } else if (this.c == 'R') {
                return new Node(this.x + 1, this.y, 'L');
            } else if (this.c == 'U') {
                return new Node(this.x, this.y + 1, 'D');
            } else {
                return new Node(this.x, this.y - 1, 'U');
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) {return false;}
            Node n = (Node) o;
            return x == n.x && y == n.y && c == n.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, c);
        }
    }
}
