package RecursionAndDP.BinaryTree;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        // Create nodes
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node6 = new Node(6);
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node4 = new Node(4);

        // Build the binary tree manually
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        Node ans = lowestCommonAncestorOfBinaryTree(node3,6,0);
        System.out.println(ans.val);
    }

    public Node lowestCommonAncestorOfBST(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.val > n1 && root.val > n2) {
            return lowestCommonAncestorOfBST(root.left, n1, n2);
        } else if (root.val < n1 && root.val < n2) {
            return lowestCommonAncestorOfBST(root.right, n1, n2);
        }
        return root;
    }

    public static Node lowestCommonAncestorOfBinaryTree(Node node, int n1, int n2) {
        if (node == null) return null;
        if (node.val == n1 || node.val == n2) return node;
        Node left = lowestCommonAncestorOfBinaryTree(node.left, n1, n2);
        Node right = lowestCommonAncestorOfBinaryTree(node.right, n1, n2);
        if (left == null) return right;
        if (right == null) return left;
        return node;
    }
}
