package Heap;

import java.util.Arrays;

public class MergeTwoBinaryMaxHeap {
    public static void main(String[] args) {
        int a[] = {10, 5, 6, 2},
                b[] = {12, 7, 9};
        int[] ans = mergeHeaps(a, b, a.length, b.length);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {

        int[] arr = new int[n + m];

        int index = 0;

        for (int i = 0; i < n; i++) {
            arr[index++] = a[i];
        }

        for (int i = 0; i < m; i++) {
            arr[index++] = b[i];
        }

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        return arr;
    }


    private static void heapify(int[] arr, int index, int n) {
        int maxIndex = index;
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        if (leftChild < n && arr[leftChild] > arr[maxIndex]) {
            maxIndex = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[maxIndex]) {
            maxIndex = rightChild;
        }
        if (index != maxIndex) {
            swap(arr, maxIndex, index);
            heapify(arr, maxIndex, n);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
