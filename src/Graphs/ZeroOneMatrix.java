package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public static void main(String[] args) {

    }

    static int[][] zeroOneMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().third;
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    queue.add(new Node(nRow,nCol,steps+1));
                }
            }
        }
        return distance;
    }
}

class Node {
    public int first;
    public int second;
    public int third;

    public Node(int a, int b, int c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }
}