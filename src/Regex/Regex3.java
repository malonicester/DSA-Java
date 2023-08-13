package Regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex3 {
    public static void main(String[] args) {
        String str = "how are\tyou?\nAjay";
        Pattern pat = Pattern.compile("\\s");
        Matcher m1 = pat.matcher(str);
        int count = 0;
        while (m1.find()) {
            count++;
//            System.out.println(m1.start()+"  "+m1.group()+" "+(m1.end()-1));
        }
        System.out.println(count);
        String[] arr = str.split("\\s");
        System.out.println(Arrays.toString(arr));

        String[] expression = {"[a-z]", "[0-9]", "[A-Z]", "[^abc]", "[^A-Za-z0-9]"};
        for (String ex : expression) {
            pat = Pattern.compile(ex);
            m1 = pat.matcher("a7b@z#9");
            while (m1.find()) {
                System.out.println(m1.start() + " " + m1.group() + "  " + (m1.end() - 1));
            }
            System.out.println("============================");
        }
    }
}
