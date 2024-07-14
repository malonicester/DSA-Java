package Heap;

public class KthSmallestElementInAMatrix {
    public static void main(String[] args) {

    }

    private static int kthSmallestElementInMatrix(int[][] arr, int k) {
        int start = arr[0][0];
        int end = arr[arr.length - 1][arr.length - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int countElementsSmallerThanMid = countElements(arr, mid);
            if (countElementsSmallerThanMid < k) {
                /*
                  There are not enough elements to be the kth smallest element
                  so increase the start
                 */
                start = mid + 1;
            } else {
                /*
                    Not making end = mid - 1 because it can be the potential answer
                    and include it in the next search space
                 */
                end = mid;
            }
        }
        return start;
    }

    private static int countElements(int[][] arr, int target) {
        int count = 0, row = arr.length - 1, col = 0;
        /*
          We start row from the last row because there is high possibility that
          mid is closer to the max element which is present in the last row
          and not the initial row because array is sorted.


          Time Complexity of the function is O(N)
           because in worst case it will traverse all the rows
         */
        while (row >= 0 && col < arr.length) {
            if (arr[row][col] <= target) {
/*
              this line shows if the arr[row][col] <= target
              then all the elements in that row is already less than target
              because it is sorted.

              Else Move to the next row
 */
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
