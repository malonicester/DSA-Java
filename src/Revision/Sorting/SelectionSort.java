package Revision.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, -1, -4, 5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //    Worst Case ->  O (N^2)
//    Best Case ->  O (N^2)
//    It performs well on small lists
//    Select an element and put it at it's right position
//    It is not an stable sorting algorithm
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = getMaxIndex(arr, 0, arr.length - 1 - i);
            swap(arr, arr.length - 1 - i, maxIndex);
        }
    }

    static int getMaxIndex(int[] arr, int i, int j) {
        int max = i;
        for (int k = i; k <= j; k++) {
            if (arr[k] > arr[i]) {
                max = k;
            }
        }
        return max;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
