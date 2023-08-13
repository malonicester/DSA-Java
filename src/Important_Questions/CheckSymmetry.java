package Important_Questions;

public class CheckSymmetry {
    public static void main(String[] args) {
        char[][] arr = {
                {'.', '.', '*'},
                {'*', '*', '.'},
                {'.', '.', '*'},
        };
        String ans = symmetry(arr);
        System.out.println(ans);
    }

    static String symmetry(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean h = true;
            boolean v = true;
            for (int j = 0; j <= arr.length / 2; j++) {
                if (arr[i][j] != arr[i][arr.length - 1 - j]) {
                    h = false;
                    break;
                }
            }
            for (int j = 0; j <= arr.length / 2; j++) {
                if (arr[j][i] != arr[arr.length - 1 - j][i]) {
                    System.out.println(arr[j][i] + " " + arr[arr.length - 1 - j][i]);
                    v = false;
                    break;
                }
            }
            if (h && !v) {
                return "VERTICAL";
            } else if (!h && v) {
                return "HORIZONTAL";
            } else  {
                return "NO";
            }
        }
        return "BOTH";
    }
}
