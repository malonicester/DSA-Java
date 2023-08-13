package Revision;

import java.util.HashSet;
import java.util.Set;

public class UniqueOddSubset {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2};
        boolean ans = uniqueOddSubset(arr,0,0,2,new HashSet<>());
        System.out.println(ans);
    }

    static boolean uniqueOddSubset(int[] arr, int index, int sum, int k, Set<Integer> set) {
        if (sum % 2 == 1 || set.size() == k) return true;
        if (index >= arr.length) return false;
        boolean flag = false;
        for (int i = index; i < arr.length; i++) {
            set.add(arr[i]);
            flag = uniqueOddSubset(arr, i + 1, sum + arr[i], k, set);
            set.remove(arr[i]);
        }
        return flag;
    }
}
