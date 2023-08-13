package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MinimumSum {
    public static void main(String[] args) {
        String s = "9";
        List<String> ans = CID(s);
        System.out.println(ans);
        int[]arr = {1,2,3};

    }

    static int minimumSum(int[] arr, int k) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < arr.length && j < arr.length) {
            sum += arr[j];
            if (j - i + 1 == k) {
                minSum = Math.min(sum, minSum);
                sum -= arr[i];
                i++;
            }
            j++;
        }
        return minSum;
    }

    static String[] phone = {"","" ,"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static List<String> CID(String s) {
        List<String> list = new ArrayList<>();
        phoneKeypad(s, s.length(), list, new StringBuilder());
        return list;
    }

    static void phoneKeypad(String s, int n, List<String> list, StringBuilder sb) {
        if (s.isEmpty()) {
            list.add(sb.toString());
            return;
        }
        int index = s.charAt(0) - '0';
        for (int i = 0; i < phone[index].length(); i++) {
            sb.append(phone[index].charAt(i));
            phoneKeypad(s.substring(1), n, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
