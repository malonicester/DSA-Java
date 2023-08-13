package Maze;

public class PracticeMaze {
    public static void main(String[] args) {
          int n = 4;
          boolean[][]board = new boolean[n][n];
        System.out.println(placeNQueens(board,0));
    }

    static int placeNQueens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += placeNQueens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        int maxLeft = Math.min(col, row);
        int maxRight = Math.min(row, board[0].length - 1 - col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) return false;
        }
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean elem : arr) {
                if (elem)
                    System.out.print("Q ");
                else System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
