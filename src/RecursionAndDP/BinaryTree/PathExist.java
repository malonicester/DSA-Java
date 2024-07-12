package RecursionAndDP.BinaryTree;

public class PathExist {
    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node9 = new Node(9);
        Node node12 = new Node(12);
        Node node10 = new Node(10);
        Node node16 = new Node(16);
        Node node8 = new Node(8);
        node3.left = node5;
        node3.right = node9;
        node9.left = node10;
        node9.right = node12;
        node10.left = node16;
        node12.left = node8;
        int[] path = {3, 9, 12, 8};
        boolean ans = pathExists(node3, path, 0);
        System.out.println(ans);

    }

    private static boolean pathExists(Node node, int[] path, int index) {
        if (index == path.length) return true;
        if (node == null) return false;
        if (node.val == path[index]) {
            index++;
        }
        else return false;
        boolean left = pathExists(node.left, path, index);
        boolean right = pathExists(node.right, path, index);
        return left || right;
    }
}
