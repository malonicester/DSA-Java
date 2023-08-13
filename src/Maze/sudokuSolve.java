package Maze;


public class sudokuSolve {
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
        if (solveSuoku(arr)) {
            print(arr);
        } else {
            System.out.println("Can't Solve");
        }
    }

    static boolean solveSuoku(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 0) {
                    for (int possibleValue = 1; possibleValue <= 9; possibleValue++) {
                        if (isSafe(board, row, col, possibleValue)) {
                            board[row][col] = possibleValue;
                            if (solveSuoku(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int[][] board, int row, int col, int possibleValue) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == possibleValue) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == possibleValue) return false;
        }
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i <rowStart+sqrt; i++) {
            for (int j = colStart; j < colStart+sqrt; j++) {
                if (board[i][j] == possibleValue) return false;
            }
        }
        return true;
    }

    static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
