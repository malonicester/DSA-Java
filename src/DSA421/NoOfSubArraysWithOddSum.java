package DSA421;

public class NoOfSubArraysWithOddSum {
    public static void main(String[] args) {
        int[]arr = {1,3,5,4};
//        System.out.println(numberOfSubArraysWithOddSum(arr));
        int no = (arr.length)*(arr.length+1)/2;
        System.out.println(no);
    }

    static int numberOfSubArraysWithOddSum(int[] arr) {
        int odd = 0, even = 0, ans = 0, n = arr.length, mod = (int) Math.pow(10, 9) + 7, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even + 1;
                odd++;
            }
        }
        return ans%mod;
    }
}
