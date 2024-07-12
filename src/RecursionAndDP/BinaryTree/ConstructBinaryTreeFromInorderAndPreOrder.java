package RecursionAndDP.BinaryTree;

import java.util.Arrays;
import java.util.List;

public class ConstructBinaryTreeFromInorderAndPreOrder {
    public static void main(String[] args) {
        Node node = constructBinaryTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        List<Integer> preOrderTraversal = TraversalOfBinaryTree.preOrderTraversal(node);
        System.out.println(preOrderTraversal);
    }

    public static Node constructBinaryTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int root = preorder[0];
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }
        Node node = new Node(root);
/*

       Arrays.copyOfRange(arr,from,to) here from is inclusive but to is exclusive
       so take one extra index for the array you want to form.

       Left SubTree
       We are taking from 1 because the 0th index of the preorder is the root itself
       but in case of inorder the root is index so 0,index - 1 is the left part

       Right SubTree
       We are taking index + 1 , preorder.length - 1 elements
       Same For Inorder
 */

        node.left = constructBinaryTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = constructBinaryTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }

}
