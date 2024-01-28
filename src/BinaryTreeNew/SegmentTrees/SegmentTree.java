package BinaryTreeNew.SegmentTrees;

public class SegmentTree {

    private Node root;


    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start, end);
        int mid = start + (end - start) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    private class Node {
        int data;
        Node left;
        Node right;
        int startInterval;
        int endInterval;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

        public int getStartInterval() {
            return startInterval;
        }

        public void setStartInterval(int startInterval) {
            this.startInterval = startInterval;
        }

        public int getEndInterval() {
            return endInterval;
        }

        public void setEndInterval(int endInterval) {
            this.endInterval = endInterval;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree segmentTree = new SegmentTree(arr);
    }
}
