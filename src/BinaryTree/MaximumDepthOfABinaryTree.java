package BinaryTree;

import java.util.List;

public class MaximumDepthOfABinaryTree {
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
        int ans = depthOfBinaryTree(root);
        System.out.println(ans);
    }

    static int depthOfBinaryTree(Node node) {
        if (node == null) return 0;
        int left = 1 + depthOfBinaryTree(node.left);
        int right = 1 + depthOfBinaryTree(node.right);
        return Math.max(left, right);
    }
}
