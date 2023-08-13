package Revision.Sorting;

import java.util.Arrays;

public class RotateElement {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateElement(arr);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    static void rotateElement(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                swap(arr, i, j);
            }
        }
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }
    }

    static void swap(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}
