package src.java_algo_stduy.dfs와bfs_이론;

import java.util.LinkedList;
import java.util.Queue;

public class _10_BFS_Tree_말단노드까지의_최단경로 {

    static Node root;
    static int level = 1;

    public static class Node {
        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            this.lt = this.rt = null;
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println(bfs(root));
    }

    public static int bfs(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (currentNode.lt == null & currentNode.rt == null) {
                    return level;
                }

                if (currentNode.lt != null)
                    queue.offer(currentNode.lt);

                if (currentNode.rt != null)
                    queue.offer(currentNode.rt);
            }

            level++;
        }

        return 0;
    }

    public static void init() {

        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
    }
}
