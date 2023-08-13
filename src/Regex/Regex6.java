package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex6 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#*!])).+");
        Matcher mat = pat.matcher("ashishT@39");
        System.out.println(mat.matches());

    }
}
