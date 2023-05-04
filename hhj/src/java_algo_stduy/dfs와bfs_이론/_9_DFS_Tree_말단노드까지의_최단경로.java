package src.java_algo_stduy.dfs와bfs_이론;

/**
 * 최단 경로이기 때문에 사실 BFS로 푸는 것이 맞음.
 */
public class _9_DFS_Tree_말단노드까지의_최단경로 {

    static Node root;

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
        System.out.println(dfs(1, root));
    }

    public static int dfs(int depth, Node node) {
        if (node.lt == null && node.rt == null) {
            return depth;
        }

        return Math.min(dfs(depth + 1, node.lt), dfs(depth + 1, node.rt));
    }

    public static void init() {

        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
    }
}
