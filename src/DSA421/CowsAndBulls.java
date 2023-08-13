package DSA421;

public class CowsAndBulls {
    public static void main(String[] args) {
        String secret = "1817";
        String guess = "8710";
        String ans = cowsAndBulls(secret, guess);
        System.out.println(ans);
    }

    static String cowsAndBulls(String secret, String guess) {
        int[] nums1 = new int[10];
        int cows = 0, bulls = 0;
        int[] nums2 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) bulls++;
            else {
                nums1[s]++;
                nums2[g]++;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            cows += Math.min(nums2[i], nums1[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
