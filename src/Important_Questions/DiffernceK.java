package Important_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiffernceK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        boolean ans = diiferenceK(arr, 8);
        System.out.println(ans);

    }

    static boolean diiferenceK(int[] arr, int k) {
        int i = 0;
        int j = 1;
        while (i < arr.length && j < arr.length) {
            int diff = Math.abs(arr[i] - arr[j]);
            if (diff == k && i != j) return true;
            if (diff < k) {
                j++;
            } else {
                i++;
            }
            if (j == i) j = i + 1;
        }
        return false;
    }
}
