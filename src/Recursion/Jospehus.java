package Recursion;

public class Jospehus {
    public static void main(String[] args) {
        System.out.println(josephusProblem(5,3));
    }
    static int josephusProblem(int n,int k){
        if(n==1) return 0;
        int x = josephusProblem(n-1,k);
        int y = (x+k)%n;
        return y;
    }
}
