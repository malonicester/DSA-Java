package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodingStreak {
    public static void main(String[] args) {
        String str1 = "SSSSEEEECCCCEECCCC";
        String str2 = "CCCCCSSSSEEECCCCSS";
        String str3 = "SSSSSEEESSCCCCCCCS";
        String str4 = "EESSSSCCCCCCSSEEEE";
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        countStreak(sb.toString());
        countStreak(str1);
        countStreak(str2);
        countStreak(str3);
        countStreak(str4);
        System.out.println(max);
    }

    public static List<Integer> max = new ArrayList<>();

    static void countStreak(String str) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'C') count++;
            else {
                list.add(count);
                count = 0;
            }
        }
        System.out.println(list);
        max.add(Collections.max(list));
    }
}
