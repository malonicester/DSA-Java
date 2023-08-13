package Important_Questions;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s  = sc.nextLine();
        String[]arr = s.split(" ");
        int[]arr1 = new int[arr.length];
        for(int i = 0;i< arr1.length;i++){
            arr1[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Arrays.toString(arr1));
    }
}
