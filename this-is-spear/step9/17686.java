import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        List<Node> list = new ArrayList<>();
        for (String file : files) {
            list.add(new Node(file));
        }

        // 문자를 하나씩 가져와 Object 에 매핑한다.
        return list.stream().sorted().map(node -> node.name).toArray(String[]::new);
    }

    private static class Node implements Comparable<Node> {
        String name;
        String head;
        int number;

        public Node(String name) {
            this.name = name;
            int len = name.length();
            // find head
            int index = 0;
            for (int i = 0; i < len; i++) {
                if ('0' <= name.charAt(i) && name.charAt(i) <= '9') {
                    index = i;
                    break;
                }
                index++;
            }
            this.head = name.substring(0, index).toLowerCase();

            int lastI = len;
            for (int i = index; i < len; i++) {
                if (!('0' <= name.charAt(i) && name.charAt(i) <= '9')) {
                    lastI = i;
                    break;
                }
            }
            this.number = Integer.parseInt(name.substring(index, lastI));
        }

        @Override
        public int compareTo(Node o) {
            if (!this.head.equals(o.head)) {return this.head.compareTo(o.head);}
            return this.number - o.number;
        }
    }
}
