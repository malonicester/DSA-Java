package Contest;

import java.util.HashMap;
import java.util.Map;

public class ExtraCharacterInString {
    public static void main(String[] args) {
        String s = "dwmodizxvvbosxxw";
        String[]arr = {"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"};
        int ans = extraCharacters(s,arr);
        System.out.println(ans);
    }

    static int extraCharacters(String s, String[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        for (String str : arr) {
            for (char ch : str.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}

/*
"dwmodizxvvbosxxw"
["ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"]
 */