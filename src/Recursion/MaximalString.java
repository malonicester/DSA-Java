package Recursion;


import java.util.Arrays;

public class MaximalString {
    public static void main(String[] args) {
        String str = "254";
        char[] arr = str.toCharArray();
        String ans = maximalString("", arr,1 , 0);
        System.out.println(ans);
    }

    public static String res = "";

    static String maximalString(String ans, char[] arr, int noOfSwaps, int index) {
        if (index == arr.length || noOfSwaps == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            if (sb.toString().compareTo(res) >= 1) {
                res = sb.toString();
            }
            return res;
        }
        String val = null;
        for (int i = index; i < arr.length; i++) {
            int maxIndex = getMax(arr, i);
            swap(arr, i, maxIndex);
            val = maximalString(ans, arr, noOfSwaps - 1, i + 1);
//            swap(arr, i, maxIndex);
        }
        return val;
    }


    static int getMax(char[] arr, int pos) {
        int max = pos;
        for (int i = pos+1; i <arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    static void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }

}
