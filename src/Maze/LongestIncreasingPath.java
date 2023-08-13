package Maze;

public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] arr = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        boolean[][] visited = new boolean[arr.length][arr.length];
        int ans = longest(arr, Integer.MIN_VALUE, 0, 0, 0, visited);
        System.out.println(ans);
    }

    public static int maxSteps = 0;

    static int longest(int[][] board, int previos, int steps, int row, int col, boolean[][] visited) {
        if (row >= board.length || row < 0 || col < 0 || col >= board[0].length) {
            return steps;
        }
        if (board[row][col] <= previos) {
            return steps;
        }
        int val = board[row][col];
        board[row][col] = Integer.MAX_VALUE;
        int up = longest(board, board[row][col], steps + 1, row - 1, col, visited);
        int down = longest(board, board[row][col], steps + 1, row + 1, col, visited);
        int right = longest(board, board[row][col], steps + 1, row, col + 1, visited);
        int left = longest(board, board[row][col], steps + 1, row, col - 1, visited);
        int max = max(left, right, up, down);
        board[row][col] = val;
        return 1 + max;
    }

    static int max(int a, int b, int c, int d) {
        int max1 = Math.max(a, b);
        int max2 = Math.max(d, c);
        return Math.max(max1, max2);
    }
}
