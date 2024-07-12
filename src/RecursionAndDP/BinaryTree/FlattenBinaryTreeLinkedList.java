package RecursionAndDP.BinaryTree;

public class FlattenBinaryTreeLinkedList {
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
        node = flattenBinaryTree(node);
        while (node != null && node.right != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }

    private static Node flattenBinaryTree(Node root) {
        Node node = root;
        while (node != null) {
            if (node.left != null) {
                Node current = node.left;
                while (current.right != null) {
                    current = current.right;
                }
                current.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
        return root;
    }
}
