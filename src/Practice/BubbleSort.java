package Practice;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, -43, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = getMaxIndex(arr, 0, arr.length - 1 - i);
            swap(arr, maxIndex, arr.length - 1 - i);
        }
    }

    static int getMaxIndex(int[] arr, int i, int j) {
        int max = i;
        for (int k = i; k <= j; k++) {
            if (arr[k] > arr[max]) {
                max = k;
            }
        }
        return max;
    }

    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else break;
            }
        }
    }

    static void mergeSort(int[] arr, int s, int e) {
        if (s >= e) return;
        int mid = s + (e - s) / 2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        merge(arr, s, e, mid);
    }

    static void merge(int[] arr, int s, int e, int mid) {
        int[] temp = new int[e - s + 1];
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
        for (int k = s; k <= e; k++) {
            arr[k] = temp[idx++];
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
