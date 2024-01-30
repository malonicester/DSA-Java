package BinaryTreeNew;

import java.util.*;

public class BFS {

    TreeNode root;

    //    Level Order Traversal
//    Traversing Because the size of the queue is the size of the queue
//    Get the top most element and add its left and right if not null
//    This will traverse all the levels
//    Time Complexity is O(n)
    public List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> list = new ArrayList<>();
        if (node == null) return list;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            list.add(currentLevel);
        }
        return list;
    }

    public TreeNode findSuccessor(TreeNode node, int key) {
        if (node == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
            if (currentNode.val == key) break;
        }
        return queue.peek();
    }

    public List<List<Integer>> zigzagLevelOrder(Node node) {
        List<List<Integer>> list = new ArrayList<>();
        if (node == null) return list;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        boolean isReversed = false;
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> elems = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                Node currentNode;
                if (!isReversed) {
                    currentNode = queue.pollFirst();
                    elems.add(currentNode.val);
                    if (currentNode.left != null) queue.addLast(currentNode.left);
                    if (currentNode.right != null) queue.addLast(currentNode.right);
                } else {
                    currentNode = queue.pollLast();
                    elems.add(currentNode.val);
                    if (currentNode.right != null) queue.addFirst(currentNode.right);
                    if (currentNode.left != null) queue.addFirst(currentNode.left);
                }
            }
            isReversed = !isReversed;
            list.add(elems);
        }
        return list;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        List<List<Integer>> list = bfs.zigzagLevelOrder(root);
        System.out.println(list);
    }
}

class Node {
    int val;
    Node left;

    Node right;

    public Node(int val) {
        this.val = val;
    }
}