package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInaMaze {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        ratInAMaze(arr,0,0,"");
        System.out.println(paths);
        Collections.sort(paths,String::compareTo);
    }

    static List<String> paths = new ArrayList<>();

    static void ratInAMaze(int[][] arr, int m, int n, String path) {
        if (m < 0 || n < 0 || m >= arr.length || n >= arr.length) return;
        if (arr[m][n] == 0) return;
        if (arr[m][n] == -1) return;
        if (m == arr.length - 1 && n == arr.length - 1) {
            paths.add(path);
            return;
        }
        arr[m][n] = -1;
        ratInAMaze(arr, m + 1, n, path + "D");
        ratInAMaze(arr, m - 1, n, path + "U");
        ratInAMaze(arr, m, n + 1, path + "R");
        ratInAMaze(arr, m, n - 1, path + "L");
        arr[m][n] = 1;
    }
}
