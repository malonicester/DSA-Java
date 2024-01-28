package BinaryTreeNew;

import java.util.Scanner;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
    }

    public void insertElements(int value) {

    }

    public void populate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root Node: ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {
        System.out.println("Do you want to Enter to the left of: " + node.value);
        boolean left = sc.nextBoolean();
        if (left) {
            System.out.print("Enter the value for left : ");
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }
        System.out.println("Do You want to Enter to right of : " + node.value);
        boolean right = sc.nextBoolean();
        if (right) {
            System.out.print("Enter the value for right : ");
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }

    }

    public void display(){
        display(root,"");
    }

    private void display(Node node, String indent) {
        if(node==null) return;
        System.out.print(indent+ node.value);
        display(node.left,"\t");
        display(node.right,"\t");
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.populate();
    }
}
