package Recursion;

import java.util.ArrayList;

public class PackerAndMover {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
//        packerAndMover(arr,3,"");
        print(arr, 3, "");
    }

    public static ArrayList<String> ans = new ArrayList<>();

    static void packerAndMover(int[] arr, int weight, String p) {
        if (weight < 0) {
            return;
        }
        if (weight == 0) {
            ans.add(p);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            packerAndMover(arr, weight - arr[i], p + arr[i]);
        }
    }

    static void print(int[] arr, int weight, String str) {
        packerAndMover(arr, weight, "");
        int max = Integer.MIN_VALUE;
        int min = 0;
        for (String s : ans) {
            if (s.length() > max) {
                max = s.length();
            }
            if (min > s.length()) {
                min = s.length();
            }
        }
        System.out.println(min + " " + max);
    }
}
