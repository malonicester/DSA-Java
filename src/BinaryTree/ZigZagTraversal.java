package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(3);
        for(int i = 0;i<3;i++){
            list.add(0);
        }
        System.out.println(list);
    }

    static List<List<Integer>> zigZagTraversal(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        boolean leftToRight = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                subList.add(0);
            }
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                int index = leftToRight ? i : size - 1 - i;
                subList.add(node.data);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            leftToRight = !leftToRight;
            list.add(subList);
        }
        return list;
    }
}
