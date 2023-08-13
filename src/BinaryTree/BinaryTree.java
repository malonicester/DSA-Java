package BinaryTree;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        List<List<Integer>> list = levelOrderTraversal(root);
        System.out.println(list);
    }

    /*
                 1
            20       30
          40   50 60    70
     */
    static void printInOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printInOrder(node.left);
        printInOrder(node.right);
    }

    static void preOrder(Node node) {
        if (node == null) return;
        preOrder(node.left);
        System.out.print(node.data + " ");
        preOrder(node.right);
    }

//    Time Complexity -> O(N) -> We are visiting each node once
//    Space Complexity -> O(N) ->N nodes
    static List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek() != null && queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek() != null && queue.peek().right != null) queue.add(queue.peek().right);
                subList.add(queue.remove().data);
            }
            list.add(subList);
        }
        return list;
    }
}

class Node {
    int data;
    Node right;
    Node left;

    public Node(int data, Node right, Node left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;

    }
}
