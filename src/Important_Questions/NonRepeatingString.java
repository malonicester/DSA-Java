package Important_Questions;

import java.util.HashMap;

public class NonRepeatingString {
    public static void main(String[] args) {
        String str = "idwmdggom";
        int ans = nonRepeatedStrings(str, 2);
        
        System.out.println(ans);
    }

    static int nonRepeatedStrings(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (i >= k) {
                char removech = str.charAt(i - k);
                if (map.get(removech) == 1) {
                    map.remove(removech);
                } else {
                    map.put(removech, map.getOrDefault(removech, 0) - 1);
                }
            }
            if (map.size() == k) {
                count++;
            }
        }
        return count;
    }

}
