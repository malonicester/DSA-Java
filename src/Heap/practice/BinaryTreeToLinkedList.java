package Heap.practice;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeToLinkedList {
    public static void main(String[] args) {

    }

    private static void morrisInorderTraversalWithoutSpace(TreeNode root) {
        TreeNode current = root;
        List<Integer> list = new ArrayList<>();
        while (current == null) {
            if (current.left != null) {
                list.add(current.val);
                current = current.right;
            } else {
                TreeNode left = current.left;
                while (left.right != null && left.right != current) {
                    left = left.right;
                }
                if (left.right == null) {
                    left.right = current;
                    current = current.left;
                } else {
                    list.add(current.val);
                    left.right = null;
                    current = current.right;
                }
            }
        }
        System.out.println(list);
    }

    private static TreeNode binaryTreeToLinkedList(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            TreeNode left = node.left;

            if (left != null) {
                while (left.right != null) {
                    left = left.right;
                }
                left.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
        return root;
    }
}
