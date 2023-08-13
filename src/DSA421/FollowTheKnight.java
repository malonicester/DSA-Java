package DSA421;

public class FollowTheKnight {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        followTheKnight(arr, 3, 3, 1);
        System.out.println(count);
    }

    static int count = 0;

    static void followTheKnight(int[][] board, int row, int col, int moves) {
        if (row < 1 || row > 10 || col < 1 || col > 10) {
            return;
        }
        if (moves == 0) {
            if (board[row][col] != 1) {
                board[row][col] = 1;
                count++;
                return;
            }
            return;
        }
        followTheKnight(board, row - 2, col + 1, moves - 1);
        followTheKnight(board, row - 2, col - 1, moves - 1);
        followTheKnight(board, row + 2, col + 1, moves - 1);
        followTheKnight(board, row + 2, col - 1, moves - 1);
        followTheKnight(board, row - 1, col + 2, moves - 1);
        followTheKnight(board, row - 1, col - 2, moves - 1);
        followTheKnight(board, row + 1, col - 2, moves - 1);
        followTheKnight(board, row + 1, col + 2, moves - 1);
    }
}
