package Maze;

public class LeetCodeSudoku {
    public static void main(String[] args) {
        char[][] ch = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(ch, 0, 0);
    }

    static void solveSudoku(char[][] board, int row, int col) {
        if (row == board.length) {
            display(board);
            return;
        }
        int nextRow = 0;
        int nextCol = 0;
        if (col == board.length - 1) {
            nextRow = row + 1;
            nextCol = 0;
        } else {
            nextRow = row;
            nextCol = col + 1;
        }
        if (board[row][col] == '.') {
            for (char possibleValues = '1'; possibleValues <= '9'; possibleValues++) {
                if (isSafe(board, row, col, possibleValues)) {
                    board[row][col] = possibleValues;
                    solveSudoku(board, nextRow, nextCol);
                    board[row][col] = '.';
                }
            }
        }else {
            solveSudoku(board,nextRow,nextCol);
        }
    }

    private static void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

   private static boolean isSafe(char[][] board, int row, int col, int nums) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == nums) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == nums) {
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == nums) {
                    return false;
                }
            }
        }
        return true;
    }
}
