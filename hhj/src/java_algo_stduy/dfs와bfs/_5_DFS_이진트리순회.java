package src.java_algo_stduy.dfs와bfs;

public class _5_DFS_이진트리순회 {

    static Node root;
    static StringBuilder pre = new StringBuilder();
    static StringBuilder mid = new StringBuilder();
    static StringBuilder next = new StringBuilder();

    public static void main(String[] args) {
        init();
        dfs(root);

        System.out.println(pre.toString());
        System.out.println(mid.toString());
        System.out.println(next.toString());
    }

    public static void dfs(Node node){
        if(node==null)
            return;

        pre.append(node.data + " ");
        dfs(node.lt);
        mid.append(node.data + " ");
        dfs(node.rt);
        next.append(node.data + " ");
    }

    public static void init(){
        root = new Node(1);

        root.lt = new Node(2);
        root.rt = new Node(3);

        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
    }

    public static class Node {

        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
            lt = rt = null;
        }
    }
}
