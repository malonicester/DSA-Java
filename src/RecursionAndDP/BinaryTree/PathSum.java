package RecursionAndDP.BinaryTree;

public class PathSum {
    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node11 = new Node(11);
        Node node7 = new Node(7);
        Node node2 = new Node(2);
        Node node8 = new Node(8);
        Node node13 = new Node(13);
        Node node4_2 = new Node(4);
        Node node1 = new Node(1);
        node5.left = node4;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node5.right = node8;
        node8.left = node13;
        node8.right = node4_2;
        node4_2.right = node1;

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        maximumPathSum(root);
        System.out.println(maxSum);
    }

    static boolean pathSum(Node node, int targetSum) {
        if (node == null) {
            return false;
        }
//       Leaf Node has no right and left
        if (node.left == null && node.right == null) {
            return node.val == targetSum;
        }
        return pathSum(node.left, targetSum - node.val) || pathSum(node.right, targetSum - node.val);
    }

    private static int sumRootToLeafNumbers(Node node) {
        int[] arr = new int[1];
        sumRootToLeaf(node, new StringBuilder(), arr);
        return arr[0];
    }

    private static void sumRootToLeaf(Node node, StringBuilder str, int[] arr) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            arr[0] += Integer.parseInt(str.toString());
            return;
        }
        str.append(node.val);
        sumRootToLeaf(node.left, str, arr);
        sumRootToLeaf(node.right, str, arr);
        str.deleteCharAt(str.length() - 1);
    }

    private static int maxSum = Integer.MIN_VALUE;

    private static int maximumPathSum(Node node) {
        if (node == null) return 0;
        int left = Math.max(0, maximumPathSum(node.left));
        int right = Math.max(0, maximumPathSum(node.right));
        int max = left + right + node.val;
        maxSum = Math.max(maxSum, max);
        return Math.max(left, right) + node.val;
    }
}
