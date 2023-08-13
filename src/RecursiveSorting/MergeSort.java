package RecursiveSorting;

import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 4, 5, 5};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        List<Integer> list = Arrays.asList(1,2,3,4,5);
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeArrays(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int idx = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[idx++] = left[i];
                i++;
            } else {
                arr[idx++] = right[j];
                j++;
            }
        }
        while (i < left.length) {
            arr[idx++] = left[i++];
        }
        while (j < right.length) {
            arr[idx++] = right[j++];
        }
        return arr;
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

    static void mergeSort(int[] arr, int s, int e) {
        if (s >= e) return;
        int mid = s + (e - s) / 2;

        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, e, mid);
    }

    private static void merge(int[] arr, int s, int e, int mid) {
        int temp[] = new int[e - s + 1];
        int i = s;
        int j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= e) {
            if (arr[i] < arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[idx++] = arr[i++];
        }
        while (j <= e) {
            temp[idx++] = arr[j++];
        }
        idx = 0;
        for (int p = s; p <= e; p++) {
            arr[p] = temp[idx++];
        }
    }
}
