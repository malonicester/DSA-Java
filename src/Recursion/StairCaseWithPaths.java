package Recursion;

import java.util.ArrayList;

public class StairCaseWithPaths {
    public static void main(String[] args) {
        ArrayList<String> ans = mazePathWithJumps(1,1,3,5);
        System.out.println(ans);
        printSubSeq("","abc");
        printStairCase(4,"");
    }

    static ArrayList<String> climbStair(int n) {
        if (n == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        if (n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> one = climbStair(n - 1);
        ArrayList<String> two = climbStair(n - 2);
        ArrayList<String> three = climbStair(n - 3);
        ArrayList<String> ans = new ArrayList<>();
        for (String s : one) {
            ans.add(1 + s);
        }
        for (String s : two) {
            ans.add(2 + s);
        }
        for (String s : three) {
            ans.add(3 + s);
        }
        return ans;
    }

    static ArrayList<String> mazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> hpaths = new ArrayList<>();
        ArrayList<String> vpaths = new ArrayList<>();

        if (sr < dr) {
            vpaths = mazePaths(sr+1 , sc, dr, dc);
        }
        if (sc < dc) {
            hpaths = mazePaths(sr, sc+1, dr, dc);
        }
        ArrayList<String> paths = new ArrayList<>();
        for (String s : hpaths) {
            paths.add("h" + s);
        }
        for (String s : vpaths) {
            paths.add("v" + s);
        }
        return paths;
    }
    static  ArrayList<String> mazePathWithJumps(int sr,int sc,int dr,int dc){
        if(sr==dr && sc==dc ){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> paths = new ArrayList<>();
        for(int ms = 1;ms<=dc-sc;ms++){
            ArrayList<String> hpaths = mazePathWithJumps(sr,sc+1,dr,dc);
            for(String s : hpaths){
                paths.add("h"+s);
            }
        }
        for(int ms = 1;ms<=dr-sr;ms++){
            ArrayList<String> vpaths = mazePathWithJumps(sr+1,sc,dr,dc);
            for(String s : vpaths){
                paths.add("v"+s);
            }
        }
        for(int ms = 1;ms<=dr-sr && ms<dc;ms++){
            ArrayList<String> dpaths = mazePathWithJumps(sr+1,sc+1,dr,dc);
            for(String s : dpaths){
                paths.add("d"+s);
            }
        }
        return paths;
    }
    static void printSubSeq(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        printSubSeq(p+ch,up.substring(1));
        printSubSeq(p,up.substring(1));
    }
    static void printStairCase(int n,String path){
        if(n<0){
            return;
        }
        if(n==0){
            System.out.println(path);
            return;
        }
        printStairCase(n-1,path+"1");
        printStairCase(n-2,path+"2");
        printStairCase(n-3,path+"3");
    }
}
