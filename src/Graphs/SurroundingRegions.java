package Graphs;

public class SurroundingRegions {
    public static void main(String[] args) {

    }


    public static void surroundingRegions(char[][] arr) {
        int n = arr.length, m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] delrow = {0, 1, 0, -1};
        int[] delcol = {1, 0, -1, 0};
        for (int i = 0; i < n; i++) {
            if (!visited[i][0] && arr[i][0] == 'O') {
                dfs(i, 0, arr, visited, delrow, delcol, n, m);
            }
            if (!visited[i][m - 1] && arr[i][m - 1] == 'O') {
                dfs(i, m - 1, arr, visited, delrow, delcol, n, m);
            }
        }
        for (int i = 0; i < m; i++) {
            if (!visited[0][i] && arr[0][i] == 'O') {
                dfs(0, i, arr, visited, delrow, delcol, n, m);
            }
            if (!visited[n - 1][i] && arr[n - 1][i] == 'O') {
                dfs(n - 1, i, arr, visited, delrow, delcol, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'O' && !visited[i][j]) {
                    arr[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int row, int col, char[][] arr, boolean[][] visited, int[] delrow, int[] delcol, int n, int m) {
        visited[row][col] = true;
        for (int i = 0; i < delrow.length; i++) {
            int r = row + delrow[i];
            int c = col + delcol[i];
            if (r >= 0 && r < n && c >= 0 && c < m) {
                if (arr[r][c] == 'O' && !visited[r][c])
                    dfs(r, c, arr, visited, delrow, delcol, n, n);
            }
        }
    }
}
