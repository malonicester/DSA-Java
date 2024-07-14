package Heap;

import RecursionAndDP.BinaryTree.Node;

public class IsBinaryTreeHeap {
    public static void main(String[] args) {

    }

    private static int count(Node node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.right);
    }

    private static boolean isCompleteBinaryTree(Node node, int index, int totalNumbers) {
        if (node == null) return true;
        if (index >= totalNumbers) return false;
        return isCompleteBinaryTree(node.left, 2 * index + 1, totalNumbers) && isCompleteBinaryTree(node.right, 2 * index + 2, totalNumbers);
    }

    private static boolean isBinaryTreeHeap(Node node) {
        boolean completeBinaryTree = isCompleteBinaryTree(node, 0, count(node));
        boolean isMaxHeap = isMaxHeap(node);
        return completeBinaryTree && isMaxHeap;
    }

    private static boolean isMaxHeap(Node node) {
        if (node == null) return true;
        if (node.left != null && node.val < node.left.val) return false;
        if (node.right != null && node.val < node.right.val) return false;
        return isMaxHeap(node.left) && isMaxHeap(node.right);
    }
}
