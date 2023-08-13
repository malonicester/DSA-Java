package DSA421;

public class RotateElements {
    public static void main(String[] args) {

    }

    static void rotateElements(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int minr = 0;
        int minc = 0;
        int maxr = n - 1;
        int maxc = m - 1;
        int prev = 0, curr = 0;
        while (minr != maxr && minc != maxc) {
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
