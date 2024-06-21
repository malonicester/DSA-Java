package Greedy;

public class LemonadeChange {
    public static void main(String[] args) {
        boolean ans = lemonadeChange(new int[]{5, 5, 10, 10, 5});
        System.out.println(ans);
/*
   5 - 0
   10 - 2
 */
    }

    public static boolean lemonadeChange(int[] arr) {
        int five = 0, ten = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) five++;
            else if (arr[i] == 10) {
                ten++;
                if (five == 0) return false;
                five--;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five-=3;
                }else return false;
            }

        }
        return true;
    }
}
