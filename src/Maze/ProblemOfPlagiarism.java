package Maze;

import java.util.ArrayList;

public class ProblemOfPlagiarism {
    public static void main(String[] args) {
        problemPlagiarism(10,2,8);
    }
    static void problemPlagiarism(int n,int l,int r){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[]arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = i+1;
        }
        boolean[]freq = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        getPermutations(list,ans,arr,l,r,freq);
        System.out.println(count);
//        System.out.println(list);
    }

    public static int count = 0;
    private static void getPermutations(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> ans, int[]arr, int l, int r,boolean[]freq) {
        if(ans.size()== arr.length){
            list.add(new ArrayList<>(ans));
            if(sum(ans,l,r)%2==1){
                count++;
            }
        }
        for (int i = 0;i<arr.length;i++){
            if(freq[i]) continue;
            freq[i] = true;
            ans.add(arr[i]);
            getPermutations(list,ans,arr,l,r,freq);
            freq[i] = false;
            ans.remove(ans.size()-1);
        }

    }

    static int sum (ArrayList<Integer> list,int l,int r){
        int sum = 0;
        for(int i = l;i<=r;i++){
            sum+=list.get(i);
        }
        return sum;
    }
}
