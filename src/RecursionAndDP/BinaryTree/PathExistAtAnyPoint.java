package RecursionAndDP.BinaryTree;

public class PathExistAtAnyPoint {
    public static void main(String[] args) {

    }

    private static int count = 0;

    private static int pathExistAtAnyPoint(Node node, int target, int sum) {
        if (sum == target) {
            count++;
        }
        if (node == null || sum > target) return 0;
        int left = pathExistAtAnyPoint(node.left, target, sum + node.val);
        int right = pathExistAtAnyPoint(node.right, target, sum + node.val);
        return Math.min(left, right);
    }
}
