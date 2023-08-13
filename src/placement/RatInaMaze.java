package placement;

import java.util.ArrayList;
import java.util.List;

public class RatInaMaze {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 1}
        };
        List<String> list = new ArrayList<>();
        ratInAMaze(arr, 0, 0, list, "");
        System.out.println(list);
    }

    static void ratInAMaze(int[][] arr, int i, int j, List<String> ans, String path) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) return;
        if (arr[i][j] == -1 || arr[i][j] == 0) return;
        if (i == arr.length - 1 && j == arr.length - 1) {
            ans.add(path);
            return;
        }
        int temp = arr[i][j];
        arr[i][j] = -1;
        ratInAMaze(arr, i + 1, j, ans, path + "D");
        ratInAMaze(arr, i, j - 1, ans, path + "L");
        ratInAMaze(arr, i, j + 1, ans, path + "R");
        ratInAMaze(arr, i - 1, j, ans, path + "U");
        arr[i][j] = temp;
    }
}
