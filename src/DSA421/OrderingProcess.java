package DSA421;

import java.util.LinkedList;
import java.util.Queue;

public class OrderingProcess {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1};
        int[] arr2 = {1, 3, 2};
        int ans = orderingTheProcess(arr1, arr2);
        System.out.println(ans);
    }

    static int orderingTheProcess(int[] given, int[] ideal) {
        int j = 0, count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < given.length; i++) {
            q.offer(given[i]);
        }
        while (!q.isEmpty() && j != ideal.length) {
            while (!q.isEmpty() && q.peek() != ideal[j]) {
                q.offer(q.remove());
                count++;
            }
            q.remove();
            count++;
            j++;
        }
        return count;
    }
}
