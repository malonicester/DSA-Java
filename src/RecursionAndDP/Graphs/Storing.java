package RecursionAndDP.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Storing {
    public static void main(String[] args) {

    }

    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        visited[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int element = queue.poll();
            list.add(element);
            for (int elem : adj.get(element)) {
                if (!visited[elem]) {
                    visited[elem] = true;
                    queue.offer(elem);
                }
            }
        }
        return list;
    }

    public static List<Integer> dfsTraversal(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        List<Integer> ans = new ArrayList<>();
        dfs(0,ans,adj,visited);
        return ans;
    }

    private static void dfs(int start, List<Integer> ans, List<List<Integer>> adj, boolean[] visited) {
        visited[start] = true;
        ans.add(start);
        for (int n : adj.get(start)) {
            if (!visited[n]) {
                dfs(n, ans, adj, visited);
            }
        }
    }
}
