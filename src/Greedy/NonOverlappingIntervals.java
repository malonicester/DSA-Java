package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}

        };
        int ans = nonOverlappingIntervals(intervals);
        System.out.println(ans);
    }

    static int nonOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int val = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > val) {
                val = intervals[i][1];
                count++;
            }
        }
        return count;
    }
}
