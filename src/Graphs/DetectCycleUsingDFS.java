package Graphs;

import java.util.ArrayList;

public class DetectCycleUsingDFS {
    public static void main(String[] args) {
        int[][]arr = {{1,2},{3,4}};

    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size() + 1];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adjList)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
        visited[node] = true;
        for (Integer a : adjList.get(node)) {
            if (!visited[a]) {
                if (dfs(a, node, visited, adjList)) return true;
            } else if (a != parent) return true;
        }
        return false;
    }
}
