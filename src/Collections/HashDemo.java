package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashDemo {
    public static void main(String[] args) {

    }

    public static Map<Character, List<String>> addName(String[] names) {
        Map<Character, List<String>> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            char ch = names[i].charAt(0);
//            if (map.containsKey(ch)) {
//                map.get(ch).add(names[i]);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(names[i]);
//                map.put(ch, list);
//            }
            List<String> temp = map.getOrDefault(ch,new ArrayList<>());
            temp.add(names[i]);
            map.put(ch,temp);
        }
        return map;
    }
}
