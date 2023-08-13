package hashing;

public class MaxVowels {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        int ans = maxVowelsInLengthK(s, k);
        System.out.println(ans);
    }
    static int maxVowelsInLengthK(String s, int k) {
        int i = 0;
        int j = 0;
        int maxLen = Integer.MIN_VALUE;
        int vowel = 0;
        while (i < s.length() && j < s.length()) {
            char ch = s.charAt(j);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel++;
            }
            if (j - i + 1 == k) {
                char ci = s.charAt(i);
                maxLen = Math.max(maxLen, vowel);
                if (ci == 'a' || ci == 'e' || ci == 'i' || ci == 'o' || ci == 'u') vowel--;
                i++;
            }
            j++;
        }
        return maxLen;
    }
}
