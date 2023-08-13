package DSA421;

import java.util.Arrays;

public class RotateMatrixElements {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},

        };
        rotateMatrixElements(arr);
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    static void rotateMatrixElements(int[][] arr) {
        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int prev = 0, curr = 0;

        while (minr != maxr && minc != maxc) {

            if (minr + 1 > maxr || minc + 1 > maxc) break;
            prev = arr[minr + 1][minc];

            for (int i = minc; i <= maxc; i++) {
                curr = arr[minr][i];
                arr[minr][i] = prev;
                prev = curr;
            }

            minr++;

            for (int i = minr; i <= maxr; i++) {
                curr = arr[i][maxc];
                arr[i][maxc] = prev;
                prev = curr;
            }

            maxc--;

            for (int i = maxc; i >= minc; i--) {
                curr = arr[maxr][i];
                arr[maxr][i] = prev;
                prev = curr;
            }

            maxr--;

            for (int i = maxr; i >= minr; i--) {
                curr = arr[i][minc];
                arr[i][minc] = prev;
                prev = curr;
            }
            minc++;
        }
    }
}
