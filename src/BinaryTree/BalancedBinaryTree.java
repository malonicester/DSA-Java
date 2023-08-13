package BinaryTree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        Node com = root.right.left = new Node(60);
        root.right.right = new Node(70);
        com.left = new Node(90);
        com.right = new Node(45);
        com.left.left = new Node(44);
        com.left.right = new Node(43);
        boolean ans = balancedTreeOrNot(root);
        System.out.println(ans);
    }

    static boolean balancedTreeOrNot(Node node) {
        if(node==null) return true;
        int height = heightOfTree(node);
        return height!=-1;
    }

    static int heightOfTree(Node node) {
        if (node == null) return 0;
        int left = 1+ heightOfTree(node.left);
        if (left == -1) return -1;
        int right = 1+ heightOfTree(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right);
    }
}
