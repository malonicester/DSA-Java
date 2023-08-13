package Revision;

import java.util.*;

public class BettyBuys {
    public static void main(String[] args) {
        int n = 40;
        List<List<Integer>> list = combinations(n, 4);
        for(List<Integer> list1 :list){
            Collections.sort(list1);
        }
        System.out.println(list);
    }

    static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        bettyBuys(n, k, list, new ArrayList<>());
        return list;
    }

    static void bettyBuys(int n, int k, List<List<Integer>> list, List<Integer> ans) {
        if (ans.size() == k) {
            if (n == 0) {
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        for (int i = 2; i <= 9; i++) {
            if (n >= i) {
                ans.add(i);
                bettyBuys(n - i, k, list, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
