package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        List<Integer> ans = preOrderIterative(root);
        System.out.println(ans);
    }

    static List<Integer> preOrderIterative(Node root) {
        Stack<Node> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            list.add(root.data);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return list;
    }
}
