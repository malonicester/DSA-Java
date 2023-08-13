package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        ArrayList<String> list = subseq("abc");
        System.out.println(list);
//        printKeyPadCombinationsIn("","23");

    }

    static String[] code = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static ArrayList<String> printKeypadCombinatins(String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        int digit = up.charAt(0) - '0';
        ArrayList<String> rres = printKeypadCombinatins(up.substring(1));
        ArrayList<String> mres = new ArrayList<>();
        for (int i = 0; i < code[digit].length(); i++) {
            char codeforch = code[digit].charAt(i);
            for (String s : rres) {
                mres.add(codeforch + s);
            }
        }
        return mres;
    }

    static void printKeyPadCombinationsIn(String p, String up) {
        if(up.isEmpty()){
            System.out.print(p+" ");
            return;
        }
        int  digit = up.charAt(0)-'0';
        for (int i = 0; i < code[digit].length(); i++) {
            char codeforch = code[digit].charAt(i);
            printKeyPadCombinationsIn(p+codeforch,up.substring(1));
        }
    }
    static ArrayList<String> keyPadInArrayList(String str)
    {
        if(str.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        int digit = str.charAt(0)-'0';
        ArrayList<String> rres = keyPadInArrayList(str.substring(1));
        ArrayList<String> mres = new ArrayList<>();
        for (int i = 0; i < code[digit].length(); i++) {
            char codeforch = code[digit].charAt(i);
            for (String s:rres){
                mres.add(codeforch+s);
            }
        }
        return mres;
    }
    static ArrayList<String> subseq(String str){
        if(str.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> rres = subseq(str.substring(1));
        ArrayList<String> mres = new ArrayList<>();
        for (String s : rres){
            mres.add(""+s);
        }
        for (String s : rres){
            mres.add(ch+s);
        }
        return mres;
    }
}
