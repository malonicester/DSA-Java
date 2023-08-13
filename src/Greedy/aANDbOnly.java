package Greedy;

public class aANDbOnly {
    public static void main(String[] args) {
        String s = "?ba??b";
        String ans = aAndBOnly(s);
        System.out.println(ans);
    }

    static String aAndBOnly(String s) {
        char[] arr = s.toCharArray();
        if ((arr.length > 1) && (arr[0] == '?') && (arr[1] != 'a')) {
            arr[0] = 'a';
        } else {
            arr[0] = 'b';
        }
        if (arr.length > 2 && arr[arr.length - 1] == '?' && arr[arr.length - 2] != 'a') {
            arr[arr.length - 1] = 'a';
        } else {
            arr[arr.length - 1] = 'b';
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == '?') {
                if (arr[i - 1] != 'a' && arr[i + 1] != 'a') {
                    arr[i] = 'a';
                } else {
                    arr[i] = 'b';
                }
            }
        }
        return String.valueOf(arr);
    }
}
