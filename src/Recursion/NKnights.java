package Recursion;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        knight(board, 0, 0, 5);
        System.out.println(count);
    }

    public static int count = 0;

    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            count++;
            return;
        }
        if (row == board.length - 1 && col == board[0].length) return;
        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;
        }
//        If The place is safe place a Knight There and Decrease Knight Count by 1;
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
//        If Place is Not Safe Move Ahead;
        knight(board, row, col + 1, knights);

    }

    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            return true;
        }
        return false;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row + 1, col - 2)) {
            if (board[row + 1][col - 2]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        if (isValid(board, row + 1, col + 2)) {
            if (board[row + 1][col + 2]) {
                return false;
            }
        }
        if (isValid(board, row + 2, col - 1)) {
            if (board[row + 1][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row + 2, col + 1)) {
            if (board[row + 2][col + 1]) {
                return false;
            }
        }
        return true;
    }


    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean elem : row) {
                if (elem) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
