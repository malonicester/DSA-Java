package Revision;

public class FindKBeautyOfNumber {
    public static void main(String[] args) {
        int n = 240;
        int ans = kBeauty(n, 2);
        System.out.println(ans);
    }

    static int kBeauty(int num, int k) {
        int temp = 0;
        int n = num;
        int zeros = (int) Math.pow(10, k);
        int rem = 0;
        while (num != 0) {
            temp = num % zeros;
            if(temp/10==0) break;
            if (n % temp == 0) rem++;
            num /= 10;
        }
        return rem;
    }
}
