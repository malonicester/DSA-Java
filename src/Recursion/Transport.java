package Recursion;

import java.util.ArrayList;

public class Transport {
    public static void main(String[] args) {
        int [] arr = {2};
        int ans =  transport(arr,6);
        System.out.println(ans);
        System.out.println(list);
//        for ()
    }
    static int truck(int[] arr, int k) {
        if (k<0) return 0;
        if(k==0) return  1;
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            val += truck(arr,k-arr[i]);
        }
        return val;
    }
    public static ArrayList<Integer> list = new ArrayList<>();
    static int  transport(int[] arr, int k){
        if(k<0) return 0;
        if(k==0) return 1;
        int val = 0;
        for(int i = 0;i<arr.length;i++){
            val+=transport(arr,k-arr[i]);
            list.add(val);
        }
        return val;
    }
}
