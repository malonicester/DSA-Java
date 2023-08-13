package Revision;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1},
        };
        ratInaMaze(arr, 0, 0, "");
        System.out.println(paths);
    }

    static List<String> paths = new ArrayList<>();

    static void ratInaMaze(int[][] arr, int i, int j, String s) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) return;
        if (arr[i][j] == -1 || arr[i][j] == 0) return;
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            paths.add(s);
            return;
        }
        int temp = arr[i][j];
        arr[i][j] = -1;
        ratInaMaze(arr, i + 1, j, s + "D");
        ratInaMaze(arr, i, j - 1, s + "L");
        ratInaMaze(arr, i, j + 1, s + "R");
        ratInaMaze(arr, i - 1, j, s + "U");
        arr[i][j] = temp;
    }
}
