package Graphs;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {

    }

    private static boolean detectCycleInDirectedGraph(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] pathVisited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if(!visited[i]) {
                if (dfs(adj, visited, pathVisited, i)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, int element) {
        visited[element] = true;
        pathVisited[element] = true;
        for (int elem : adj.get(element)) {
            if (!visited[elem]) {
                if (dfs(adj, visited, pathVisited, elem)) return true;
            } else if (pathVisited[elem]) return true;
        }
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        pathVisited[element] = false;
        return false;
    }
}
