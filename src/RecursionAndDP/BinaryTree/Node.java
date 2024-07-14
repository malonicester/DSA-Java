package RecursionAndDP.BinaryTree;

public class Node {
    public Node left;
    public Node right;
    public int val;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", val=" + val +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the object is compared with itself
        if (this == obj) {
            return true;
        }

        // Check if the object is an instance of Node
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Node other = (Node) obj;

        // Check if the values of the nodes are equal
        if (this.val != other.val) {
            return false;
        }

        // Check if the left children are equal
        if (this.left == null) {
            if (other.left != null) {
                return false;
            }
        } else if (!this.left.equals(other.left)) {
            return false;
        }

        // Check if the right children are equal
        if (this.right == null) {
            if (other.right != null) {
                return false;
            }
        } else if (!this.right.equals(other.right)) {
            return false;
        }

        // If all checks passed, the nodes are equal
        return true;
    }
}
