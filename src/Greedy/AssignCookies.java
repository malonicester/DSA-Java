package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int ans = assignCookies(new int[]{1,2},new int[]{1,2,3});
        System.out.println(ans);
    }

    /**
     * Go Greedy by Cookie Because
     * we have to give the lowest possible value to the g[i]
     * which is equal or greater than s[i].
     * so it is better to sort them and go in a two pointer approach
     * @param g
     * @param s
     * @return
     */
    public static int assignCookies(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0 ,j = 0;

        while (i < g.length && j < s.length){
            if(s[j] >= g[i]){
                count++;
                j++;
                i++;
            }
            else j++;
        }
        return count;
    }
}
