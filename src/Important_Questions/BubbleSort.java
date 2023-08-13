package Important_Questions;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void selectionSort(int[]arr){
        for(int i = 0;i<arr.length;i++){
            int start = 0;
            int end = arr.length-1-i;
            int maxIndex = getMaxIndex(arr,start,end);
            swap(arr,maxIndex,i);
        }
    }

    private static int getMaxIndex(int[] arr,int start,int end) {
        int max = start;
        for(int i = start;i<=end;i++){
            if(arr[i]>arr[max]){
                max = i;
            }
        }
        return max;
    }
}
