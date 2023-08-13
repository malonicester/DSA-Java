package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex4 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("^[6-9]\\d{9}");
        Matcher m1 = pat.matcher("9861126831");
        System.out.println(m1.matches());

        pat = Pattern.compile("^[A-Za-z\\s]+$");
        m1 = pat.matcher("Masai School is in Bangalore");
        System.out.println(m1.matches());

        pat = Pattern.compile("^[a-z0-9_.]+@[a-z.]+$");
        m1 = pat.matcher("ashish.tripathy39@gmail.com");
        System.out.println(m1.matches());

        pat = Pattern.compile("[^abc][\\w+]");
        m1 = pat.matcher("Harshit");
        while (m1.find()){
            System.out.println(m1.group());
        }
        pat = Pattern.compile("\\D");
        m1 = pat.matcher("ashish");
        int count = 0;
        while (m1.find()){
            count++;
        }
        System.out.println(count);
    }
}
