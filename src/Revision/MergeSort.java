package Revision;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, -1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int s, int e) {
        if (s >= e) return;
        int mid = s + (e - s) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, e, mid);
    }

    static void merge(int[] arr, int s, int e, int mid) {
        int[] res = new int[e - s + 1];
        int idx = 0;
        int i = s;
        int j = mid + 1;
        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                res[idx++] = arr[i++];
            } else res[idx++] = arr[j++];
        }
        while (i <= mid) {
            res[idx++] = arr[i++];
        }
        while (j <= e) {
            res[idx++] = arr[j++];
        }
        idx = 0;
        for (int k = s; k <= e; k++) {
            arr[k] = res[idx++];
        }
    }
}
