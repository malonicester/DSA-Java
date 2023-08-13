package Revision;

public class WordSearch {
    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        boolean ans = isPresent(arr, word);
        System.out.println(ans);
    }

    static boolean wordSearch(char[][] arr, String word, int i, int j, int idx) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) return false;
        if (arr[i][j] != word.charAt(idx) || arr[i][j] == '#') return false;
        if (idx == word.length() - 1) return true;
        char temp = arr[i][j];
        arr[i][j] = '#';
        boolean north = wordSearch(arr, word, i - 1, j, idx + 1);
        boolean south = wordSearch(arr, word, i + 1, j, idx + 1);
        boolean west = wordSearch(arr, word, i, j - 1, idx + 1);
        boolean east = wordSearch(arr, word, i, j + 1, idx + 1);
        arr[i][j] = temp;
        return north || south || west || east;
    }

    static boolean isPresent(char[][] arr, String word) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (wordSearch(arr, word, i, j, 0)) return true;
            }
        }
        return false;
    }
}
