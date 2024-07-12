package RecursionAndDP.BinaryTree;

import java.util.*;

public class TraversalOfBinaryTree {
    public static void main(String[] args) {
        // Constructing the tree manually
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node6 = new Node(6);
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node node8 = new Node(8);
        Node node7 = new Node(7);
        Node node4 = new Node(4);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        List<Integer> levelOrderTraversal = inorderTraversal(node3);
        System.out.println(levelOrderTraversal);
    }

    public static List<Integer> levelOrderTraversal(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }

    public static List<Integer> preOrderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return list;
    }

    public static List<Integer> postOrderTraversalUsing2Stack(Node root) {
        if (root == null) return new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        List<Integer> list = new ArrayList<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            Node node = st1.pop();
            st2.push(node);
            if (node.left != null) {
                st1.push(node.left);
            }
            if (node.right != null) {
                st1.push(node.right);
            }
        }
        while (!st2.isEmpty()) {
            list.add(st2.pop().val);
        }
        return list;
    }

    public static List<Integer> postOrderTraversal(Node root) {
        if (root == null) return new ArrayList<>();
        Stack<Node> st = new Stack<>();
        st.push(root);
        List<Integer> list = new ArrayList<>();
        while (!st.isEmpty()) {
            Node node = st.pop();
            list.add(node.val);
            if (node.left != null) {
                st.push(node.left);
            }
            if (node.right != null) {
                st.push(node.right);
            }
        }
        return list.reversed();
    }

//    Have recursive approach in mind while solving
    public static List<Integer> inorderTraversal(Node root) {
        if (root == null) return new ArrayList<>();
        Node node = root;
        Stack<Node> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        st.push(root);
        while (!st.isEmpty()) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                node = st.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
