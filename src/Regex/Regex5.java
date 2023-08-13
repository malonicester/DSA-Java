package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex5 {
    public static void main(String[] args) {
//        PAN
        Pattern pat = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
        Matcher m1 = pat.matcher("BHCPT7376J");
        System.out.println(m1.matches());

        System.out.println("=============");
//        AADHAR
        pat = Pattern.compile("\\d{12}");
        m1 = pat.matcher("408120045047");
        System.out.println(m1.matches());
        char ch = 64+(((89+4)%89)-1);
        System.out.println(ch);
        System.out.println("===========================");
        System.out.println("khasd");
        pat = Pattern.compile("^[abc]+$");
        m1 = pat.matcher("abcd");
        System.out.println(m1.matches());

        System.out.println("==================================================");

        pat = Pattern.compile("\\d");
        m1  = pat.matcher("12abc");
        System.out.println(m1.matches());
        int count = 0;
        while (m1.find()){
            count++;
        }
        System.out.println("find "+ count);

    }
}
