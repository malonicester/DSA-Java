package RecursionAndDP.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public static void main(String[] args) {
        Node node = new Node(1);

        // Right subtree
        node.right = new Node(3);
        node.right.right = new Node(6);

        // Left subtree
        Node left = node.left = new Node(2);
        left.left = new Node(4);
        left.left.left = new Node(7);
        left.left.right = new Node(8);
        left.right = new Node(5);
        left.right.right = new Node(9);
        List<Integer> list = morrisPreorder(node);
        System.out.println(list);
    }

    private static List<Integer> morrisInorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Node node = root;

        while (node != null) {
            // If the left child is null, process the current node and move to the right child
            if (node.left == null) {
                list.add(node.val);
                node = node.right;
            } else {
                // Find the rightmost node in the left subtree or a node that already points to the current node
                Node current = node.left;
                while (current.right != null && current.right != node) {
                    current = current.right;
                }

                // If the rightmost node's right is null, create a temporary link to the current node and move to the left child
                if (current.right == null) {
                    current.right = node;
                    node = node.left;
                } else {
                    // If the rightmost node's right points to the current node, it means we've finished the left subtree
                    // Remove the temporary link, process the current node, and move to the right child
                    current.right = null;
                    list.add(node.val);
                    node = node.right;
                }
            }
        }
        return list;
    }

    private static List<Integer> morrisPreorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Node node = root;

        while (node != null) {
            // If the left child is null, process the current node and move to the right child
            if (node.left == null) {
                list.add(node.val);
                node = node.right;
            } else {
                // Find the rightmost node in the left subtree or a node that already points to the current node
                Node current = node.left;
                while (current.right != null && current.right != node) {
                    current = current.right;
                }

                // If the rightmost node's right is null, create a temporary link to the current node and move to the left child
                if (current.right == null) {
                    list.add(node.val);
                    current.right = node;
                    node = node.left;
                } else {
                    // If the rightmost node's right points to the current node, it means we've finished the left subtree
                    // Remove the temporary link, process the current node, and move to the right child
                    current.right = null;
                    node = node.right;
                }
            }
        }
        return list;
    }
}
