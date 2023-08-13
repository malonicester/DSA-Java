package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        List<Integer> list = inorderIterative(root);
        System.out.println(list);
    }

    static List<Integer> inorderIterative(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) break;
                node = st.pop();
                list.add(node.data);
                node = node.right;
            }
        }
        return list;
    }
}
