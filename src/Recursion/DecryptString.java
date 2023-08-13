package Recursion;

public class DecryptString {
    public static void main(String[] args) {
        String str = "abcdefghijk";
        char c = '3';
        decryptString(str);
//        System.out.println(Character.isDigit(c));
//        System.out.println(decompose("a3b2"));
    }

    static void decryptString(String s) {
        if (s.length() == 0) {
            return;
        }
        System.out.print(s.charAt(s.length() / 2));

        decryptString(s.substring(0, (s.length()) / 2));
        decryptString(s.substring(s.length() / 2 + 1));
    }

    static StringBuilder decompose(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int n = Integer.parseInt(c + "");
                for (int j = 0; j < n - 1; j++) {
                    sb.append(str.charAt(i - 1));
                }
            } else {
                sb.append(c);
            }
        }
        return sb;
    }


}
