package Recursion;

import java.util.Arrays;

public class Practice1 {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 3, 5, 6, 7, 8, 3, 4, 5, 3};
//        System.out.println(findFirstOccurance(arr, 5, 6));
//        System.out.println(Arrays.toString(arr));
//        int[] ans = allOcuurances(arr, 3, 0, 0);
//        System.out.println(Arrays.toString(ans));
        System.out.println(bobAndBoxes(2));
        System.out.println(power(2,5));
        System.out.println(waysToN(4));
        System.out.println(waysToN(5));
        System.out.println(tribonacciNumber(6));
    }

    static int findFirstOccurance(int[] arr, int n, int target) {
        if (n == 0) {
            return -1;
        }
        if (arr[0] == target) {
            return 0;
        }
        if (arr[n - 1] == target) return n - 1;
        return findFirstOccurance(arr, n - 1, target);
    }

    static int[] allOcuurances(int[] arr, int target, int index, int fsf) {
        if (index == arr.length) {
            int[] ans = new int[fsf];
            return ans;
        }
        if (arr[index] == target) {
//            If target is found fsf = found so far will increase by 1
//            first continued by Refernce variable
            int[] iarr = allOcuurances(arr, target, index + 1, fsf + 1);
//            At base condition will get the object created
            iarr[fsf] = index;
            return iarr;
        } else {

            int[] iarr = allOcuurances(arr, target, index + 1, fsf);
            return iarr;
        }
    }

    static int bobAndBoxes(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return bobAndBoxes(n - 1) + bobAndBoxes(n - 3) + bobAndBoxes(n - 5);
    }

    static int power(int n, int x) {
        if (x == 0) return 1;
        int temp = power(n, x / 2);
        if (x % 2 == 0) return temp * temp;
        else return n * temp * temp;
    }
    static int waysToN(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        return waysToN(n-1)+waysToN(n-2)+waysToN(n-5);
    }
    static int tribonacciNumber(int n){
        if(n<=0) return 0;
        if(n==1 || n==2) return 1;
        return tribonacciNumber(n-1)+tribonacciNumber(n-2)+tribonacciNumber(n-3);
    }
}
