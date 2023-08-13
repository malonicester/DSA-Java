package BinaryTree;

public class MaximumPathSum {
    public static void main(String[] args) {

    }

    static int maximumPathSum(Node node, int[] sum) {
        if (node == null) return 0;
        int left = Math.max(0, maximumPathSum(node.left, sum));
        int right = Math.max(0, maximumPathSum(node.right, sum));
        sum[0] = Math.max(sum[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }
}
