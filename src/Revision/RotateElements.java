package Revision;

public class RotateElements {
    public static void main(String[] args) {

    }

    static void rotateElements(int[][] arr) {
        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int prev = 0;
        int curr = 0;
        while (minr != maxr && minc != maxr) {
            if (minr + 1 > maxr || minc + 1 > maxc) break;
            prev = arr[minr + 1][minc];
            for (int i = minc; i <= maxc; i++) {
                curr = arr[minr][i];
                arr[minr][i] = curr;
                prev = curr;
            }
            minr++;
            for (int i = minr; i <= maxr; i++) {
                curr = arr[i][maxc];
                arr[i][maxc] = curr;
                prev = curr;
            }
            maxc--;
            for (int i = maxc; i >= minc; i--) {
                curr = arr[maxr][i];
                arr[maxr][i] = curr;
                prev = curr;
            }
            maxr--;
            for (int i = maxr; i >= minr; i--) {
                curr = arr[i][minc];
                arr[i][maxr] = curr;
                prev = curr;
            }
            minr++;
        }
    }
}
