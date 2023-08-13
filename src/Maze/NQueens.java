package Maze;


public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));

    }

    static int queens(boolean[][] board, int row) {
//        BaseCondition-->After Placing All the Queens-->Traversing The Entire Matrix
        if (row == board.length) {
            display(board);
            return 1;
        }
        int count = 0;
//        Placing The Queens and checking for every row and col
        for (int col = 0; col < board[0].length; col++) {
//        Place The Queen If it is safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }


    private static boolean isSafe(boolean[][] board, int row, int col) {
//        Check Vertical Row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
//        Diagonal Left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row-i][col-i]) {
                return false;
            }
        }
//        Diagonal Right
        int maxRight = Math.min(row, board[0].length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean elem : row) {
                if (elem) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
