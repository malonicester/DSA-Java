package BinaryTree;


import java.util.List;

public class DiameterOfTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        int[]arr = new int[1];
        int diameter = diameter(root,arr);
        System.out.println(arr[0]);
    }

    static int diameter(Node node, int[] diameter) {
        if (node == null) return 0;
        int left = diameter(node.left, diameter);
        int right = diameter(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return 1 + Math.max(left, right);
    }
}
