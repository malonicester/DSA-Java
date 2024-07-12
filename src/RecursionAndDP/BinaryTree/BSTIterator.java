package RecursionAndDP.BinaryTree;

import java.util.Stack;

public class BSTIterator {

    private final Stack<Node> stack = new Stack<>();

    public BSTIterator(Node node) {
        pushAll(node);
    }

    public static void main(String[] args) {

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    private void pushAll(Node node) {
        while (node != null) {
            stack.push(node);
        }
    }
}
