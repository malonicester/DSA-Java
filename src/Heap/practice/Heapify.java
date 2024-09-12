package Heap.practice;

import java.util.Arrays;
import java.util.List;

public class Heapify {
    public static void main(String[] args) {
        List<Integer> list = List.of(20, 30, 40, 90, 24, -25);
        Integer[] arr = list.toArray(Integer[]::new);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapify(Integer[] arr, int n, int index) {
        int largestIndex = index;
        int leftChild = largestIndex * 2 + 1;
        int rightChild = largestIndex * 2 + 2;
        if (leftChild < n && arr[leftChild] > arr[largestIndex]) {
            largestIndex = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[largestIndex]) {
            largestIndex = rightChild;
        }
        if (index != largestIndex) {
            swap(arr, index, largestIndex);
            heapify(arr, n, largestIndex);
        }
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void addElementToHeap(Integer[] arr, int index) {
        int largest = index;
        while (largest > 0) {
            int parent = (largest - 1) / 2;
            if (arr[largest] > arr[parent]) {
                swap(arr, largest, parent);
                largest = parent;
            } else break;
        }
    }

    private static void heapifyIteration(Integer[] arr, int n, int index) {
        int largest = index;
        while (true) {
            int leftChild = largest * 2 + 1;
            int rightChild = largest * 2 + 2;
            int currentLargest = largest;
            if (leftChild < n && arr[leftChild] > arr[currentLargest]) {
                currentLargest = leftChild;
            }
            if (rightChild < n && arr[rightChild] > arr[currentLargest]) {
                currentLargest = rightChild;
            }
            if (largest == currentLargest) break;
            swap(arr, largest, currentLargest);
            largest = currentLargest;
        }
    }

    private static void heapSort(Integer[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyIteration(arr, arr.length, i);
        }
//        max Heap Ready
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapifyIteration(arr, i, 0);
        }
    }
}
