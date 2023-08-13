package Maze;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        solve(arr, 0, 0);
//        display(arr);
    }

    static void solve(int[][] board, int row, int col) {
        if (row == board.length) {
            display(board);
            return;
        }
        int nextRow = 0;
        int nextCol = 0;
//        At Extreme Ends of Column
        if (col == board.length - 1) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }
        if (board[row][col] != 0) {
            solve(board, nextRow, nextCol);
        } else {
            for (int possibleValue = 1; possibleValue <= 9; possibleValue++) {
                if (isSafe(board, row, col, possibleValue)) {
                    board[row][col] = possibleValue;
                    solve(board, nextRow, nextCol);
                    board[row][col] = 0;
                }
            }
        }
    }

    static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();

        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
//        Check the row
        for (int i = 0; i < board[0].length; i++) {
//            Check if the number we are trying to put is already in the row or not
            if (board[row][i] == num) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) return false;
        }
//        int smi = row / 3 * 3;
//        int smj = col / 3 * 3;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (board[smi + i][smj + j] == num) return false;
//            }
//        }
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;
        for (int i = rowStart; i < rowStart+sqrt ; i++) {
            for (int j = colStart; j < colStart+sqrt; j++) {
                if (board[i][j]==num) return false;
            }
        }
        return true;
    }
}
