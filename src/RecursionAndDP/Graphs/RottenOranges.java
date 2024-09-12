package RecursionAndDP.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2}
        };
        int ans = rottenOranges(arr);
        System.out.println(ans);
    }

    public static int rottenOranges(int[][] arr) {
        // Queue<{{row,col},time}>
        Queue<Pair<Pair<Integer, Integer>, Integer>> queue = new LinkedList<>();
        int n = arr.length, m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    queue.offer(new Pair<>(new Pair<>(i, j), 0));
                }
            }
        }
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaColumn = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> first = queue.peek().getFirst();
            int row = first.getFirst();
            int col = first.getSecond();
            int timing = queue.peek().getSecond();
            time = Math.max(timing, time);
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int neighbouringRow = row + deltaRow[i];
                int neighbouringColumn = col + deltaColumn[i];
                if (
                        (neighbouringRow >= 0 && neighbouringRow < n && neighbouringColumn >= 0 && neighbouringColumn < m)
                                && arr[neighbouringRow][neighbouringColumn] == 1
                                && !visited[neighbouringRow][neighbouringColumn]
                ) {
                    queue.offer(new Pair<>(new Pair<>(neighbouringRow, neighbouringColumn), time + 1));
                    visited[neighbouringRow][neighbouringColumn] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) return -1;
            }
        }
        return time;
    }
}
