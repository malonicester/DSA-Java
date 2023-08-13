package Important_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RemoveUnSorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5, 7, 8, 6, 9, 10};
        removeUnsorted(arr);
    }

    static void removeUnsorted(int[] arr) {
        List<Integer> list = new ArrayList<>();
        if(arr[0]<arr[1] && arr.length>=2){
            list.add(arr[0]);
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>arr[i-1]){
                list.add(arr[i]);
            }
        }

        System.out.println(list);
    }
}
