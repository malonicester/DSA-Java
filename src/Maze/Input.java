package Maze;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The string");
        char[] ch = sc.next().toCharArray();
        System.out.println(Arrays.toString(ch));
    }
}
