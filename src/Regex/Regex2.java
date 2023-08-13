package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {
        String str = "value has a value only if the value is valued";
        Pattern pat = Pattern.compile("value");
        Matcher m1 = pat.matcher(str);
        int count = 0;
        while (m1.find()) {
            count++;
            System.out.println(m1.start() + " " + (m1.end() - 1) + "   " + m1.group());
        }
        System.out.println("The Word value is found for " + count + " Times");
    }
}
