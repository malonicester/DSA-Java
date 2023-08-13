package Recursion;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;
import java.util.List;

public class PhoneKeypad {
    public static void main(String[] args) {
        print("","23");
//        System.out.println(ans);
    }

    static String[] code = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    static List<String> letterCombination(String str) {
//        Base condition when length of string reaches zero return new Arraylist which will point to the reference variable from which function was called
        if (str.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        char ch = str.charAt(0);
        List<String> rres = letterCombination(str.substring(1));
        List<String> mres = new ArrayList<>();
//        Getting particular set of character for the digit

        for (int i = 0; i < code[ch - '0'].length(); i++) {

//            Taking each digit from the code array and combining with the results that are coming from the recursive function call
            char codeforch = code[ch - '0'].charAt(i);
            for (String s : rres) {
                mres.add(codeforch + s);
            }

        }
//        Passing Arraylist to future function calls
        return mres;
    }
    static void printKeyPadCombinations(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch =  ques.charAt(0);
        String restOfQuestion = ques.substring(1);
        for(int i = 0;i<code[ch-'0'].length();i++){
            char codeforch = code[ch-'0'].charAt(i);
            printKeyPadCombinations(restOfQuestion,ans+codeforch);
        }
    }
    static void printKeyPadCombinations1(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String restOfQuestion = ques.substring(1);
        for(int i = 0;i<code[ch-'0'].length();i++){
            char codeforch = code[ch-'0'].charAt(i);
            printKeyPadCombinations1(restOfQuestion,ans+codeforch);
        }
    }
    static void print (String ans,String str){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        for(int i = 0;i<code[ch-'0'].length();i++){
            char codeforch = code[ch-'0'].charAt(i);
            print(ans+codeforch,str.substring(1));
        }
    }
}
