package Maze;

public class CanPlaceQueens {
    public static void main(String[] args) {
//        char[][] board = {
//                {'Q', '.', '.', '.'},
//                {'.', '.', '.', '.'},
//                {'.', '.', '.', '.'},
//                {'.', '.', 'Q', '.'},
//        };
//        char[][] board = {
//                {'.', '.'},
//                {'.', '.'}
//        };
        char[][] board = {
                {'.', 'Q', '.', '.'},
                {'.', '.', '.', '.'},
                {'Q', '.', '.', '.'},
                {'.', '.', '.', '.'},
        };
        int q = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q') q++;
            }
        }
        int ans = nQueens(board, 0, board.length - q);
        System.out.println(ans);
    }

    static int nQueens(char[][] board, int row, int queens) {
        if (queens == 0) {
            printBoard(board);
            return 1;
        }
        if (row == board.length) {
            if (queens == 0) {
                printBoard(board);
                return 1;
            }
            return 0;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'K';
                count += nQueens(board, row + 1, queens - 1);
                board[row][col] = '.';
            }
            if (col == board[0].length - 1 && row < board.length - 1) {
                row = row + 1;
                col = 0;
            }
        }

        return count;
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 'Q' || board[row][i] == 'K') {
                return false;
            }
        }
//        Check Vertical Row
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q' || board[i][col] == 'K') {
                return false;
            }
        }
//        Diagonal Left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i] == 'Q' || board[row - i][col - i] == 'K') {
                return false;
            }
        }
        int maxRight = Math.min(row, board[0].length - col - 1);

        for (int i = 1; i <= maxRight; i++) {
            if (board[row + 1][col - 1] == 'Q' || board[row + 1][col - 1] == 'K') {
                return false;
            }
        }
//        Diagonal Right
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i] == 'Q' || board[row - i][col + i] == 'K') {
                return false;
            }
        }
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row + 1][col + 1] == 'Q' || board[row + 1][col + 1] == 'K') {
                return false;
            }
        }
        return true;
    }

//    private static boolean isSafe(char[][] board, int row, int col) {
//        for (int i = 0; i < board[0].length; i++) {
//            if (board[row][i] == 'Q' || board[row][i] == 'K') return false;
//        }
//        for (int i = 0; i < row; i++) {
//            if (board[i][col] == 'Q' || board[i][col] == 'K') return false;
//        }
//        int maxLeft = Math.min(row, col);
//        int maxRight = Math.min(row, board[0].length - 1 - col);
//        for (int i = 1; i <= maxLeft; i++) {
//            if (board[row - i][col - i] == 'Q' || board[row - i][col - i] == 'K') return false;
//        }
//        for (int i = 1; i <= maxRight; i++) {
//            if (board[row - i][col + i] == 'Q' || board[row - i][col + i] == 'K') return false;
//        }
//        return true;
//    }

    static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' || board[i][j] == 'K') {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
