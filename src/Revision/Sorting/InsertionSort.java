package Revision.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, -1};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }

    //    Worst Case O(N^2)
// Steps get reduced when array is sorted
//    Number of swaps are reduced as compared to bubbleSort
//    it is stable sorting algorithm
// Works good array is partially sorted.
//    It takes part in hybrid sorting algorithm
//    If two Objects have equal value they appear in same order
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    SelectionSort.swap(arr, j, j - 1);
                } else break;
            }
        }
    }

    static void insert(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]){
                    SelectionSort.swap(arr,j,j-1);
                }else break;
            }
        }
    }
}
