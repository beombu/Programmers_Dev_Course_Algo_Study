import java.util.HashSet;

public class 방문_길이 {
    public static int distance = 0;

    public static void main(String[] args) {
        String dirs = "LULLLLLLU";

        int result = new 방문_길이().solution(dirs);
        System.out.println(result);
    }

    public int solution(String dirs) {
        Node node = new Node(0, 0);
        HashSet<String> set = new HashSet<>();

        for (char c : dirs.toCharArray()) {
            if (c == 'U' && node.y < 5) {
                node.y++;
                String str = node.x + "," + (node.y - 0.5);
                set.add(str);
            } else if (c == 'D' && node.y > -5) {
                node.y--;
                String str = node.x + "," + (node.y + 0.5);
                set.add(str);
            } else if (c == 'R' && node.x < 5) {
                node.x++;
                String str = (node.x - 0.5) + "," + node.y;
                set.add(str);
            } else if (c == 'L' && node.x > -5) {
                node.x--;
                String str = (node.x + 0.5) + "," + node.y;
                set.add(str);
            }
        }
        distance = set.size();
        return distance;
    }

    class Node {
        double x;
        double y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}