package Greedy;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        boolean ans = jumpGame(arr);
        System.out.println(ans);
    }

    public static boolean jumpGame(int[] arr) {
//      Stay At the final Position and
//      Start from the index - 1 of the final position check if you can reach to the final position from the index
//      if you can then move to the left and update the final position
        int finalPosition = arr.length - 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] + i >= finalPosition){
                finalPosition = i;
            }
        }
        return finalPosition == 0;
    }


}
