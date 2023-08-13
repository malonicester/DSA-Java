package DSA421;

import java.util.Arrays;

public class RotateByKElements {
    public static void main(String[] args) {
        int[] arr = {-1, -100, 3, 99};
        int k = 2;
        rotateArray(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    static void rotateArray(int[] arr, int k) {
        k = k % arr.length;
        int i = 0, j = arr.length-1-k;
        while (i < j) {
            swap(arr, i++, j--);
        }
        j = arr.length - 1;
        i = arr.length-k;
        while (i < j) {
            swap(arr, i++, j--);
        }
        i = 0;
        j = arr.length - 1;
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
