package Maze;

public class KnightPractice {
    public static void main(String[] args) {
        boolean[][]board = new boolean[3][3];
        placeNKnights(board,0,0,5);
        System.out.println(count);
    }

    public static int count = 0;
    static void placeNKnights(boolean[][] board, int row, int col, int knights) {
        if ( knights == 0) {
            count++;
            display(board);
            return;
        }
        if(row== board.length-1 && col==board.length){
            return;
        }
        if (col == board[0].length) {
            placeNKnights(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            placeNKnights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        placeNKnights(board,row,col+1,knights);
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

    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean elem : row) {
                if (elem) {
                    System.out.print("K ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
