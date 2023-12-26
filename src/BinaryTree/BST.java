package BinaryTree;

public class BST {
    private Node root;

    private class Node {
        private Node left;
        private Node right;
        private int height;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
