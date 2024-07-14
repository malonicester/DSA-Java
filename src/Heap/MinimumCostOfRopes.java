package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostOfRopes {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 6, 9};
        int ans = minimumCostRopes(arr, arr.length);
        System.out.println(ans);
    }

    private static void heapify(int[] arr, int index, int n) {
        int minIndex = index;
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        while (leftChild < n) {
/*
         assign it to the index because it should be at the correct position
         in the tree.
 */

            if (arr[leftChild] < arr[minIndex]) {
                minIndex = leftChild;
            }
            if (rightChild < n && arr[rightChild] < arr[minIndex]) {
                minIndex = rightChild;
            }
            if (index != minIndex) {
                swap(arr, minIndex, index);
                index = minIndex;
                leftChild = 2 * minIndex + 1;
                rightChild = 2 * minIndex + 2;
            } else break;
        }
        Queue<Integer> queue = new PriorityQueue<>(3,Comparator.reverseOrder());

    }

    private static void minHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    private static int minimumCostRopes(int[] arr, int n) {
        int cost = 0;
        minHeap(arr, n);
        while (n > 1) {
            // Extract the two smallest ropes
            int firstMin = arr[0];
            swap(arr, 0, n - 1); // Move the last element to the root
            n--; // Decrease the size of the heap
            heapify(arr, 0, n); // Heapify the reduced heap

            int secondMin = arr[0];
            swap(arr, 0, n - 1); // Move the new last element to the root
            n--; // Decrease the size of the heap
            heapify(arr, 0, n); // Heapify the reduced heap

            // Calculate the cost of merging these two ropes
            int mergeCost = firstMin + secondMin;

            // Add the merge cost to the total cost
            cost += mergeCost;

            // Insert the merged rope back into the heap
            arr[n] = mergeCost;
            n++; // Increase the size of the heap
            heapify(arr, 0, n); // Heapify the heap again
        }
        return cost;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
