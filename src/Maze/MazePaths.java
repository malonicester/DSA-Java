package Maze;

import java.util.ArrayList;
import java.util.List;

public class MazePaths {
    public static void main(String[] args) {
//        printPaths("", 3, 3);
        System.out.println();
//        System.out.println(printPathsInList("", 3, 3));
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true},
        };
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.remove(list.size()-1);
        System.out.println(list);
        printPathsWithRestrictions("",maze,0,0);
    }

    static void printPaths(String p, int r, int c) {
//        D-->Diagonal
//        H-->Horizontal
//        V-->Vertical
        if (r == 1 || c == 1) {
            System.out.print(p + " ");
            return;
        }
        if (r > 1 && c > 1) {
            printPaths(p + "D", r - 1, c - 1);
        }
        if (r > 1) {
            printPaths(p + "V", r - 1, c);
        }
        if (c > 1) {
            printPaths(p + "H", r, c - 1);
        }
    }

    static void printPathsWithRestrictions(String p, boolean[][] maze, int r, int c) {
//        D-->Diagonal
//        H-->Horizontal
//        V-->Vertical
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.print(p + " ");
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        if (r < maze.length - 1) {
            printPathsWithRestrictions(p + "D", maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            printPathsWithRestrictions(p + "R", maze, r, c + 1);
        }
    }

    static List<String> printPathsInList(String p, int r, int c) {
//        D-->Diagonal
//        H-->Horizontal
//        V-->Vertical
        if (r == 1 || c == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> res = new ArrayList<>();
        if (r > 1 && c > 1) {
            res.addAll(printPathsInList(p + "D", r - 1, c - 1));
        }
        if (r > 1) {
            res.addAll(printPathsInList(p + "V", r - 1, c));
        }
        if (c > 1) {
            res.addAll(printPathsInList(p + "H", r, c - 1));
        }
        return res;
    }
}
