package DP;

import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        String word = "SEE";
        boolean ans = wordExist(arr,word);
        System.out.println(ans);
        Scanner sc = new Scanner(System.in);
    }

    static boolean findWord(char[][] arr, int i, int j, String word, int idx) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == '#' || arr[i][j] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length()-1) return true;
        char temp = arr[i][j];
        arr[i][j] = '#';
        boolean north = findWord(arr, i - 1, j, word, idx + 1);
        boolean south = findWord(arr, i + 1, j, word, idx + 1);
        boolean west = findWord(arr, i, j - 1, word, idx + 1);
        boolean east = findWord(arr, i, j + 1, word, idx + 1);
        arr[i][j] = temp;
        return north || south || west || east;
    }
    static boolean wordExist(char[][]arr,String word){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(findWord(arr,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
}
