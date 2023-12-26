package BinaryTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.populate(new Scanner(System.in));
        tree.display();
    }
}
