package Maze;

public class PracitceQ {
    public static void main(String[] args) {
        boolean[][] board = new boolean[5][5];

        System.out.println(nQueens(board, 0));
    }

    static int nQueens(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += nQueens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        int maxLeft = Math.min(row, col);
        int maxright = Math.min(row, board[0].length - 1 - col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) return false;
        }
        for (int i = 1; i <= maxright; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    }
}
