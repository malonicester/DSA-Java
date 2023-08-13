package Maze;

import java.util.HashMap;

public class ElementInMiddle {
    public static void main(String[] args) {
        int[] arr = {4 ,3, 6 ,7 ,8};
        int ans = elementInMiddle(arr);
        System.out.println(ans);
    }

    static int elementInMiddle(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            j = i;
            boolean left = true;
            while (j > 0) {
                if (map.get(j - 1) > arr[i]) {
                    left = false;
                    break;
                }
                j--;
            }
            j = i;
            boolean right = true;
            while (j < arr.length-1) {
                if (map.get(j + 1) < arr[i]) {
                    right = false;
                    break;
                }
                j++;
            }
            if (left && right) return arr[i];
        }
        return -1;
    }
}
