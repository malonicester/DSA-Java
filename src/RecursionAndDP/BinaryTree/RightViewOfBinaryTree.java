package RecursionAndDP.BinaryTree;

import java.util.*;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {

    }

    //    Right View Represents the right most node of each level
    private static List<Integer> rightSideViewOfTree(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return Collections.emptyList();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
//          Queue Size At Each Iteration Represents the Level of Binary Tree
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
//          Iterating over all the elements in the level and pushing it's children to the queue
//          At the same time collecting values of the node of the current level because we have to grab the right most element which will be last element of the list
            for (int i = 0; i < level; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            res.add(list.getLast());
        }
        return res;
    }

    private static List<Integer> rightSideViewOfTreeWithoutSpace(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return Collections.emptyList();
        queue.offer(root);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int level = queue.size();
            Node node = null;
            for (int i = 0; i < level; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(node.val);
        }
        return res;
    }
}
