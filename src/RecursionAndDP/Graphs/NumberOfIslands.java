package RecursionAndDP.Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands {
    public static void main(String[] args) {

    }

    private static int numberOfIslands(char[][] arr) {
        List<List<Integer>> adj = getAdj(arr);
        int count = 0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[adj.get(i).getFirst()]) {
                count++;
                dfs(adj.get(i).getFirst(), adj, visited);
            }
        }
        return count;
    }

    private static void dfs(int start, List<List<Integer>> adj, boolean[] visited) {
        visited[start] = true;
        for (int element : adj.get(start)) {
            if (!visited[element]) {
                dfs(element, adj, visited);
            }
        }
    }

    private static List<List<Integer>> getAdj(char[][] arr) {
        List<List<Integer>> adj = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '1') {
                    adj.get(i).add(j);
                }
            }
        }
        return adj;
    }
}
