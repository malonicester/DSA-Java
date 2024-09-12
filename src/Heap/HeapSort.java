package Heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {42, 7, 29, 14, 53, 20, 5, 89, 33, 12};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int[] arr, int n) {
        toMaxHeap(arr, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, 0, i);
        }
    }

    private static void heapify(int[] arr, int index, int n) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (arr[largest] != arr[index]) {
            swap(arr, largest, index);
            heapify(arr, largest, n);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void toMaxHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

}
