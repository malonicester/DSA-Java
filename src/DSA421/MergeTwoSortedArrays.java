package DSA421;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {20,10};
        int[] arr2 = {50,50};
        int[] ans = mergeArrays(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }

    static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] <= arr2[j]) {
                arr1[k--] = arr2[j--];
            } else {
                arr1[k--] = arr1[i--];
            }
        }
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
        return arr1;
    }

    static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] >= arr2[j]) {
                arr[idx++] = arr1[i++];
            } else {
                arr[idx++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            arr[idx++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[idx++] = arr2[j++];
        }
        return arr;
    }

}
