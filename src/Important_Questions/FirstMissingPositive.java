package Important_Questions;

import java.util.Collections;
import java.util.HashMap;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[]arr = {3,4,-1,1};
        System.out.println(firstMissingPostive(arr));

    }
    static int firstMissingPostive(int[]arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int num = 1;
        while (map.containsKey(num)){
            num++;
        }
        return num;
    }
}
