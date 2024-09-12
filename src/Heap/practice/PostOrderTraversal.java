package Heap.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {

    }

    private static List<Integer> iterativePostOrder(TreeNode root) {
        TreeNode node = root;
        TreeNode lastVisited = null;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || node != null) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
            TreeNode peek = st.peek();
            if (peek.right != null && lastVisited != peek.right) {
                node = peek.right;
            } else {
                st.pop();
                list.add(peek.val);
                lastVisited = peek;
            }
        }
        return list;
    }
}
