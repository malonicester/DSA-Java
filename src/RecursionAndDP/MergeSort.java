package RecursionAndDP;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = {-1, 2, 3};
        int[] arr2 = {-2, 3, 5,};
        int[] arr = new int[]{2, 1, 3, -21, 2};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));


    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (end - start == 1) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        mergeSortInPlace(arr, start, mid, end);
    }


    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] new_arr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, index = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] >= arr2[j]) {
                new_arr[index++] = arr2[j++];
            } else {
                new_arr[index++] = arr1[i++];
            }
        }
        while (i < arr1.length) {
            new_arr[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            new_arr[index++] = arr2[j++];
        }
        return new_arr;
    }

    public static void mergeSortInPlace(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start];
        int i = start, j = mid, k = 0;

        // Merge the two halves into temp
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from the left half, if any
        while (i < mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right half, if any
        while (j < end) {
            temp[k++] = arr[j++];
        }

        // Copy the merged elements back into the original array
        for (i = start, k = 0; i < end; i++, k++) {
            arr[i] = temp[k];
        }
    }

}
