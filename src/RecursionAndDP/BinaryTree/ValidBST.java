package RecursionAndDP.BinaryTree;

public class ValidBST {
    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(1);
        node.right = new Node(4);
        node.right.left = new Node(3);
        node.right.right = new Node(6);
        boolean ans = isValidBST(node);
        System.out.println(ans);
    }

    /*
        This code does not take into account that each node of the left subtree should be lesser than the root node
        and each node in the right subtree should be greater than the root node
     */
    public static boolean isValidBST(Node root) {
        if (root == null) return true;
        Node left = root.left;
        Node right = root.right;
        boolean a = true;
        boolean b = true;
        if (left != null && left.val >= root.val) {
            a = false;
        }
        if (right != null && right.val <= root.val) {
            b = false;
        }
        if (!a || !b) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static boolean bstValidHelper(Node root, Integer low, Integer high) {
        if (root == null) return true;
        if (low != null && root.val <= low) return false;
        if (high != null && root.val >= high) return false;
        boolean left = bstValidHelper(root.left, low, root.val);
        boolean right = bstValidHelper(root.right, root.val, high);
        return left && right;
    }
}
