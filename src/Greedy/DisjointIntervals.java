package Greedy;

import java.util.ArrayList;
import java.util.List;

public class DisjointIntervals {
    public static void main(String[] args) {

    }

    static int maximumDisJointIntervals(int[] start, int[] end) {
        int ans = 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(start[i]);
            arr.add(end[i]);
            list.add(arr);
        }
        list.sort((a, b) -> a.get(1) - b.get(1));
        int val = list.get(0).get(1);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).get(0) > val) {
                val = list.get(i).get(1);
                ans++;
            }
        }
        return ans;
    }

}
