package src.java_algo_stduy.dfs와bfs_이론;

public class _5_DFS_이진트리순회 {

    static Node root;
    static StringBuilder 전위순회 = new StringBuilder();
    static StringBuilder 중위순회 = new StringBuilder();
    static StringBuilder 후위순회 = new StringBuilder();

    public static class Node {

        int data;
        Node lt, rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }

    public static void main(String[] args) {
        init();
        dfs(root);

        System.out.println(전위순회.toString());
        System.out.println(중위순회.toString());
        System.out.println(후위순회.toString());
    }

    public static void dfs(Node node) {
        if (node == null)
            return;

        전위순회.append(node.data + " ");
        dfs(node.lt);
        중위순회.append(node.data + " ");
        dfs(node.rt);
        후위순회.append(node.data + " ");
    }

    public static void init() {
        root = new Node(1);

        root.lt = new Node(2);
        root.rt = new Node(3);

        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
    }
}
