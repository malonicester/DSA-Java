package Important_Questions;

public class WhiteBlackStrips {
    public static void main(String[] args) {
        String s = "BBWBW";
        int ans = whiteBlackStrips(s,0);
        System.out.println(ans);
    }

    static int whiteBlackStrips(String s, int k) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'B') {
                count++;
                maxCount = Math.max(count, maxCount);
            } else count = 0;
            if (maxCount >= k) return 0;
        }
        int B = 0;
        int W = 0;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < s.length() && j < s.length()) {
            char ch = s.charAt(j);
            if (ch == 'B') B++;
            else W++;
            if (j - i + 1 >= k) {
                if (B + W == k) {
                    min = Math.min(min, W);
                }
                if (s.charAt(i) == 'B') B--;
                else W--;
                i++;
            }
            j++;
        }
        return min;
    }

}
