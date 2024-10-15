package Graphs;

import RecursionAndDP.Graphs.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {

    }

    private static boolean isBipartiteOrNot(int[][] arr) {
        int[] colorOfElements = new int[arr.length];
        Arrays.fill(colorOfElements, -1);
        for (int i = 0; i < arr.length; i++) {
            if (colorOfElements[i] == -1) {
                if (!checkBipartite(arr, colorOfElements, i)) return false;
            }
        }
        return true;
    }

    private static boolean checkBipartite(int[][] arr, int[] colorOfElements, int start) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        colorOfElements[start] = 1; // Assign the first color
        queue.offer(new Pair<>(start, 1)); // Start with this vertex

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> parent = queue.poll();
            int parentElement = parent.getFirst();
            int parentColor = parent.getSecond();
            int[] elements = arr[parentElement];

            for (int element : elements) {
                // If the neighbor hasn't been colored yet
                if (colorOfElements[element] == -1) {
                    colorOfElements[element] = parentColor == 0 ? 1 : 0; // Alternate color
                    queue.offer(new Pair<>(element, colorOfElements[element]));
                }
                // If the neighbor is colored the same as the parent
                else if (parentColor == colorOfElements[element]) {
                    return false; // Not bipartite
                }
            }
        }
        return true;
    }

    private static boolean checkBipartiteWithDFS(int[][] arr, int[] colorOfElements, int start, int parentColor) {
        colorOfElements[start] = parentColor == 0 ? 1 : 0;
        for (int element : arr[start]) {
            if (colorOfElements[element] == -1) {
                if (!checkBipartiteWithDFS(arr, colorOfElements, element, colorOfElements[start])) return false;
            } else if (colorOfElements[element] == parentColor) return false;
        }
        return true;
    }
}
