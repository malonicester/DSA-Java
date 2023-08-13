package Revision;

import java.util.ArrayList;
import java.util.List;

public class ShuffleAll {
    public static void main(String[] args) {
        String[] arr = {"ab", "cd"};
        List<String> list = new ArrayList<>();
        shuffleAll(arr, 0, list, new StringBuilder());
        System.out.println(list);
        int n = 2;
        beautifulPermutations(n,1,new boolean[n+1]);
        System.out.println(count);
    }

    static void shuffleAll(String[] arr, int index, List<String> list, StringBuilder sb) {
        if (index == arr.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr[index].length(); i++) {
            sb.append(arr[index].charAt(i));
            shuffleAll(arr, index + 1, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static int count = 0;

    static void beautifulPermutations(int n, int index, boolean[] visited) {
        if (index > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                visited[i] = true;
                beautifulPermutations(n, index + 1, visited);
                visited[i] = false;
            }
        }
    }
}
