package Maze;
//https://www.codechef.com/problems/KNIGHTS
public class PlaceMaximumKnight {
    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '#', '.', '.'},
                {'#', '.', '.', '#', '.'},
                {'#', '#', '.', '.', '.'},
                {'.', '.', '.', '#', '#'},
                {'.', '.', '.', '.', '.'},
        };
//        char[][] board = {
//                {'.', '.', '.', '.'},
//                {'.', '.', '.', '.'}
//        };

        placeMaxKnights(board, 0, 0);
        System.out.println(max_count);

    }

    static void placeMaxKnights(char[][] board, int row, int col) {

        if (row == board.length - 1 && col == board[0].length) {
            display(board);
            return;
        }
        if (col == board[0].length) {
            placeMaxKnights(board, row + 1, 0);
            return;
        }
        if (board[row][col] != '#' && isSafe(board, row, col)) {
            board[row][col] = 'O';
            placeMaxKnights(board, row, col + 1);
            board[row][col] = '.';
        }
        placeMaxKnights(board, row, col + 1);
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1] == 'O') {
                return false;
            }
        }
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1] == 'O') {
                return false;
            }
        }
        if (isValid(board, row + 1, col - 2)) {
            if (board[row + 1][col - 2] == 'O') {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2] == 'O') {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2] == 'O') {
                return false;
            }
        }
        if (isValid(board, row + 1, col + 2)) {
            if (board[row + 1][col + 2] == 'O') {
                return false;
            }
        }
        if (isValid(board, row + 2, col - 1)) {
            if (board[row + 1][col - 1] == 'O') {
                return false;
            }
        }
        if (isValid(board, row + 2, col + 1)) {
            if (board[row + 2][col + 1] == 'O') {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(char[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            return true;
        }
        return false;
    }

    public static int max_count = 0;

    private static void display(char[][] board) {
        int count = 0;
        for (char[] row : board) {
            for (char elem : row) {
                if (elem == 'O') {
//                    System.out.print("K ");
                    count++;
                } else {
//                    System.out.println(". ");
                }
            }
//            System.out.println();
        }
        if (count > max_count) {
            max_count = count;
        }
//        System.out.println();
    }

}
