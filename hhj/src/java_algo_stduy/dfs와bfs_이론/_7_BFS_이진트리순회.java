package src.java_algo_stduy.dfs와bfs_이론;

import java.util.LinkedList;
import java.util.Queue;

public class _7_BFS_이진트리순회 {

    static Node root;

    static class Node {

        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            this.lt = this.rt = null;
        }
    }

    public static void main(String[] args) {
        init();

        bfs(root, 1);
    }

    private static void bfs(Node node, int level) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(level + " : ");

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                stringBuilder.append(currentNode.data + " ");

                if (currentNode.lt != null) {
                    queue.offer(currentNode.lt);
                }
                if (currentNode.rt != null) {
                    queue.offer(currentNode.rt);
                }
            }

            level++;
            System.out.println(stringBuilder);
        }
    }

    private static void init() {

        root = new Node(1);

        root.lt = new Node(2);
        root.rt = new Node(3);

        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
    }
}
