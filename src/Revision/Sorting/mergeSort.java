package Revision.Sorting;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, -1, 2, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int s, int e) {
        if (s >= e) return;
        int mid = s + (e - s) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        mergeSortedArray(arr, s, e, mid);
    }

    static void mergeSortedArray(int[] arr, int s, int e, int mid) {
        int[] ans = new int[e - s + 1];
        int i = s;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                ans[index++] = arr[i++];
            } else {
                ans[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            ans[index++] = arr[i++];
        }
        while (j <= e) {
            ans[index++] = arr[j++];
        }
        index = 0;
        for (int k = s; k <= e; k++) {
            arr[k] = ans[index++];
        }
    }

    static void quickSort(int[] arr, int s, int e) {
        if (s >= e) return;
        int low = s;
        int high = e;
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];
        while (low <= high) {

        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
