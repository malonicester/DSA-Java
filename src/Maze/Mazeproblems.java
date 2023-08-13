package Maze;

public class Mazeproblems {
    public static void main(String[] args) {
        System.out.println(count(3,3));
    }

//    No of ways to go from top left to bottom right of a  matrix
    static int count(int r, int c) {
        if (r == 1 || c == 1) return 1;
        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return left + right;
    }
}
