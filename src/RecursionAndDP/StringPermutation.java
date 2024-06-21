package RecursionAndDP;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String[] args) {
        reverse(512);
        System.out.println(sum);

    }

    public static void permutation(String str) {
        List<String> list = new ArrayList<>();
        permutation(str, "", 0, list);
        System.out.println(list);
    }

    private static void permutation(String str, String abc, int index, List<String> list) {
        if (str.isEmpty()) {
            list.add(abc);
            return;
        }
        char ch = str.charAt(index);
        for (int i = 0; i < str.length(); i++) {
            permutation(str.substring(index + 1), abc + ch, index + 1, list);
        }
    }

    static int sum = 0;

    public static void reverse(int num) {
        if (num == 0) return;
        int val = num % 10;
        sum = val + sum * 10;
        reverse(num / 10);
    }
}
/**
 * 512 -> 500 + 10 + 2
 * 215 -> 200 + 10 + 5
 * 2 * 10 = 20
 * 20 * 10 + 200
 */
