import java.util.HashMap;

public class 방문_길이 {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int RIGHT = 2;
    public static final int LEFT = 3;
    public static final int MAX_POINT = 5;
    public static final int MIN_POINT = -5;

    public static int distance = 0;

    public static void main(String[] args) {
        String dirs = "ULURRDLLU";

        int result = new 방문_길이().solution(dirs);
        System.out.println(result);
    }

    public int solution(String dirs) {
        HashMap<Node, boolean[]> map = new HashMap<>();
        Node node = new Node(0, 0);

        for (char ch : dirs.toCharArray()) {
            if (ch == 'U') {
                if (!isEndWay(node.getY())) {
                    node.setY(node.getY() + 1);
                    checkDistance(map, node, UP);
                    //System.out.println("UP : " + node.getX() + " " + node.getY());
                    //System.out.println(distance);
                }
            } else if (ch == 'D') {
                if (!isEndWay(node.getY())) {
                    node.setY(node.getY() - 1);
                    checkDistance(map, node, DOWN);
//                    System.out.println("DOWN : " + node.getX() + " " + node.getY());
//                    System.out.println(distance);
                }
            } else if (ch == 'R') {
                if (!isEndWay(node.getX())) {
                    node.setX(node.getX() + 1);
                    checkDistance(map, node, RIGHT);
//                    System.out.println("RIGHT : " + node.getX() + " " + node.getY());
//                    System.out.println(distance);
                }
            } else if (ch == 'L') {
                if (!isEndWay(node.getX())) {
                    node.setX(node.getX() - 1);
                    checkDistance(map, node, LEFT);
//                    System.out.println("LEFT : " + node.getX() + " " + node.getY());
//                    System.out.println(distance);
                }
            }
        }

        return distance;
    }

    private boolean isEndWay(int point) {
        return point >= MAX_POINT || point <= MIN_POINT;
    }

    private void checkDistance(HashMap<Node, boolean[]> map, Node node, int way) {
        if (!map.containsKey(node)) {
            System.out.println("아예 안돌아?");
            boolean[] arr = new boolean[4];
            arr[way] = true;
            map.put(node, arr);
            distance++;
        } else {
            if (!map.get(node)[way]) {
                map.get(node)[way] = true;
                distance++;
                System.out.println("여길돌았니?1");
            }
            System.out.println("여길돌았니?2");
        }
    }

    class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}