package Recursion;

public class KnightMove {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        followTheKnight(arr, 1, 1, 2);
        System.out.println(count);
    }

    public static int count = 0;

    static void followTheKnight(int[][] arr, int n, int m, int moveCount) {
        if (n < 1 || n >10 || m < 1 || m >10) {
            return;
        }
        if (moveCount == 0) {
            if(arr[n][m]!=1){
                arr[n][m] = 1;
                count++;
                return;
            }
            return;
        }
        followTheKnight(arr, n - 2, m - 1, moveCount - 1);
        followTheKnight(arr, n - 2, m + 1, moveCount - 1);
        followTheKnight(arr, n + 2, m - 1, moveCount - 1);
        followTheKnight(arr, n + 2, m + 1, moveCount - 1);
        followTheKnight(arr, n - 1, m + 2, moveCount - 1);
        followTheKnight(arr, n + 1, m + 2, moveCount - 1);
        followTheKnight(arr, n - 1, m - 2, moveCount - 1);
        followTheKnight(arr, n + 1, m - 2, moveCount - 1);
    }
}
