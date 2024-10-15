package Graphs;

public class NumberOfEnclaves {
    public static void main(String[] args) {

    }

    private static int numberOfEnclaves(int[][] arr) {
        int numberOfEnclaves = 0;
        int n = arr.length, m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] delRow = {0, 1, 0, -1};
        int[] delCol = {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && arr[i][0] == 1) {
                dfs(i, 0, arr, delRow, delCol, visited, n, m);
            }
            if (!visited[i][m - 1] && arr[i][m - 1] == 1) {
                dfs(i, m - 1, arr, delRow, delCol, visited, n, m);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!visited[0][i] && arr[0][i] == 1) {
                dfs(0, i, arr, delRow, delCol, visited, n, m);
            }
            if (!visited[n - 1][i] && arr[n - 1][i] == 1) {
                dfs(n - 1, i, arr, delRow, delCol, visited, n, m);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    numberOfEnclaves++;
                }
            }
        }
        return numberOfEnclaves;
    }

    private static void dfs(int row, int col, int[][] arr, int[] delrow, int[] delcol, boolean[][] visited, int n, int m) {
        visited[row][col] = true;
        for (int i = 0; i < delrow.length; i++) {
            int r = delrow[i] + row;
            int c = delcol[i] + col;
            if (r >= 0 && r < n && c >= 0 && c < m && arr[r][c] == 1 && !visited[r][c]) {
                dfs(r, c, arr, delrow, delcol, visited, n, m);
            }
        }
    }
}
