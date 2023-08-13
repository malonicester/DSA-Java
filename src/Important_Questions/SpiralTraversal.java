package Important_Questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        spiralTraversal(arr,arr.length,arr[0].length);
    }

    static void spiralTraversal(int[][] arr, int n, int m) {
        int tne = m * n;
        int minr = 0;
        int minc = 0;
        int maxr = n - 1;
        int maxc = m - 1;
        int count = 0;
        while (count < tne) {
            for (int i = minc; i <= maxc && count < tne; i++) {
                System.out.print(arr[minr][i] + " ");
                count++;
            }
            minr++;
            for (int i = minr; i <= maxr && count < tne; i++) {
                System.out.print(arr[i][maxc] + " ");
                count++;
            }
            maxc--;
            for (int i = maxc; i >= minc && count < tne; i--) {
                System.out.print(arr[maxr][i] + " ");
                count++;
            }
            maxr--;
            for (int i = maxr; i >= minr && count < tne; i--) {
                System.out.print(arr[i][minc] + " ");
            }
            minc++;
        }
    }
}
