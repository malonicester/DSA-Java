package placement;

import java.util.HashMap;
import java.util.Map;

public class ChefsRecipe {
    public static void main(String[] args) {

    }

    static void chefsRecipe(String[] s) {
        Map<String, Integer> map = new HashMap<>();
        int fiber = 0, fat = 0, carb = 0, protien = 0, seas = 0;
        int i = 0, j = 0;
        while (i < s.length && j < s.length) {

            if (detectDish(s[i]) == 1) {

            }

            if (detectDish(s[j]) == 1) {
                fiber++;
            } else if (detectDish(s[j]) == 2) {
                fat++;
            } else if (detectDish(s[j]) == 3) {
                carb++;
            } else if (detectDish(s[j]) == 4) {
                protien++;
            } else {
                seas++;
            }
            j++;
        }
    }

    static int detectDish(String s) {
        if (s.startsWith("Fi")) return 1;
        if (s.startsWith("Fa")) return 2;
        if (s.startsWith("Ca")) return 3;
        if (s.startsWith("P")) return 4;
        if (s.startsWith("S")) return 5;
        return 0;
    }

    static boolean isExpired(int i, int exp) {
        return i + 1 > exp;
    }
}
