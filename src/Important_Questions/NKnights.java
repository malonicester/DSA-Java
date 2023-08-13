package Important_Questions;


import java.util.Arrays;

public class NKnights {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 2, 0, 0},
                {2, 0, 0, 2, 0},
                {2, 2, 0, 0, 0},
                {0, 0, 0, 2, 2},
                {0, 0, 0, 0, 0}
        };
        placeMaximumKnights(arr, 0, 0);
        System.out.println(maxCount);
        for(int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }

    public static int maxCount = 0;

    static void placeMaximumKnights(int[][] board, int row, int col) {
        if (row == board.length - 1 && col == board[0].length ) {
            print(board);
//            System.out.println();
            return;
        }
        if (col == board[0].length) {
            placeMaximumKnights(board, row + 1, 0);
            return;
        }

        if (board[row][col] == 0) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                placeMaximumKnights(board, row, col + 1);
                board[row][col] = 0;
            }
        }
        placeMaximumKnights(board, row, col + 1);

    }

    private static boolean isSafe(int[][] board, int row, int col) {
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1] == 1) return false;
        }
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1] == 1) return false;
        }
        if (isValid(board, row + 2, col - 1)) {
            if (board[row + 2][col - 1] == 1) return false;
        }
        if (isValid(board, row + 2, col + 1)) {
            if (board[row + 2][col + 1] == 1) return false;
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2] == 1) return false;
        }
        if (isValid(board, row + 1, col - 2)) {
            if (board[row + 1][col - 2] == 1) return false;
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2] == 1) return false;
        }
        if (isValid(board, row + 1, col + 2)) {
            if (board[row + 1][col + 2] == 1) return false;
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            return true;
        }
        return false;
    }

    private static void print(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    count++;
//                    System.out.print("K ");
                } else {
//                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        if (count > maxCount) {
            maxCount = count;
        }
    }
}
