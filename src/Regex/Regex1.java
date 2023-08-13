package Regex;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[^AEIOUaeiou/\s+]");
        Pattern p1 = Pattern.compile("[\s+]");
        Matcher m = p.matcher("Ashish Tripathy");
        String str = "Ashish Tripathy";
        String[] str1 = str.split("[\s+]");
        System.out.println(Arrays.toString(str1));
        int count = 0;
        while (m.find()) {
            count++;
        }
        System.out.println(count);
        Pattern p2 = Pattern.compile("^[A-Za-z0-9_.]+@[a-zA-Z.]+$");
        m = p2.matcher("ashish.tripathy39@gmail.com");
        System.out.println(m.matches());
    }
}
