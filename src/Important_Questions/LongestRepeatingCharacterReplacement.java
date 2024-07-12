package Important_Questions;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "AABABBA";
        int ans = longestRepeatingCharacterReplacement(str, 1);
        System.out.println(ans);
    }

    private static int longestRepeatingCharacterReplacement(String str, int k) {
        int[] freq = new int[26];
        int res = 0, i = 0, j = 0, n = str.length(), maxFreq = 0;
        while (i < n && j < n) {
            char ch = str.charAt(i);
            freq[ch - 'A']++;
            if (maxFreq < freq[ch - 'A']) {
                maxFreq = freq[ch - 'A'];
            }
            while ((i - j + 1) - maxFreq > k) {
                ch = str.charAt(j);
                int index = ch - 'A';
                freq[index]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
            i++;
        }
        return res;
    }

    private static int max(int[] freq) {
        int res = 0;
        for (int r : freq) {
            if (r > res){
                res = 0;
            }
        }
        return res;

    }
}
