package RecursionAndDP.BinaryTree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConstructBinaryTreeFromInorderAndPostOrder {
    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        Node node = constructBinaryTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        List<Integer> preOrderTraversal = TraversalOfBinaryTree.preOrderTraversal(node);
        System.out.println(preOrderTraversal);
    }

    public static Node constructBinaryTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        int root = postorder[postorder.length - 1];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }
        Node node = new Node(root);
        node.left = constructBinaryTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        node.right = constructBinaryTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
        return node;
    }

    public static Node constructBinaryTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart == postEnd) return null;
        int root = postorder[postEnd];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }
        Node node = new Node(root);
        node.left = constructBinaryTree(inorder, postorder, inStart, index - 1, postStart, index - 1);
        node.right = constructBinaryTree(inorder, postorder, index + 1, inEnd, index, postEnd - 1);
        return node;
    }


//    Constructing a Binary Tree From Null Values

    private static Node constructBinaryTreeFromPreOrder(Integer[] preorder) {
        List<Integer> list = Arrays.asList(preorder);
        Iterator<Integer> iterator = list.iterator();
        return treeBuilder(iterator);
    }

    private static Node treeBuilder(Iterator<Integer> itr) {
        if (!itr.hasNext()) {
            return null;
        }
        Integer value = itr.next();
        if (value == null) return null;
        Node node = new Node(value);
        node.left = treeBuilder(itr);
        node.right = treeBuilder(itr);
        return node;
    }
}
