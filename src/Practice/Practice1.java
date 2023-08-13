package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice1 {
    public static void main(String[] args) {
        String[] arr= {"wc","lch"};
        printCombinations(arr);
    }

    static void printCombinations(String[] arr) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        getCombinations(list,sb,arr,0);
//        Collections.sort(list);
        System.out.println(list);
    }

    private static void getCombinations(List<String> list, StringBuilder sb, String[] arr, int idx) {
        if(idx == arr.length){
            list.add(sb.toString());
            return;
        }
        for(int i = 0;i<arr[idx].length();i++){
            sb.append(arr[idx].charAt(i));
            getCombinations(list,sb,arr,idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
