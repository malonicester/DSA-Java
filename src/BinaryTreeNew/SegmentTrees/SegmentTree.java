package BinaryTreeNew.SegmentTrees;

import java.util.Objects;

public class SegmentTree {

    private Node root;


    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        String str = "";
        if (Objects.nonNull(node.left)) {
            str += "Interval[" + node.left.startInterval + "-" + node.left.endInterval + "] and data is " + node.left.data + " -> ";
        } else str = "No Left Child";
        //For Current Node
        str += "Interval[" + node.left.startInterval + "-" + node.left.endInterval + "] and data is " + node.left.data + " -> ";

        if (Objects.nonNull(node.right)) {
            str += "Interval[" + node.right.startInterval + "-" + node.right.endInterval + "] and data is " + node.right.data + " -> ";
        }
        System.out.println(str);
        if (Objects.nonNull(node.left)) display(node.left);
        if (Objects.nonNull(node.right)) display(node.right);
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

    //    qsi -> Query Start Index
//    qei -> Query End Index
    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            //node is lying inside query -> we will take all the item inside it
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            return 0;
        }
//        Reach till the correct node and get the data by recursion
        return query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
    }

    public void update(int index,int value){
        this.root.data =  update(index,value,this.root);
    }
    private int update(int index, int value, Node node) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
            }
            int leftAns = update(index,value,node.left);
            int rightAns = update(index,value,node.right);
            node.data = leftAns + rightAns;
            return node.data;
        }
        return node.data;
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
