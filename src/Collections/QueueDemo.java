package Collections;

import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<>(new Sort());
        q.add(89);
        q.add(45);
        q.add(17);
        q.add(34);
        q.add(76);
        q.add(28);
        q.add(90);
        q.add(23);
        System.out.println(q.peek());
        System.out.println(q);
        q.remove();
//        q.remove();
        System.out.println(q);
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 1);
        map.put('d', 2);
        map.put('e', 9);
        Set<Map.Entry<Character,Integer>> st = map.entrySet();
        Iterator<Map.Entry<Character,Integer>> itr = st.iterator();
        while(itr.hasNext()){
            Map.Entry<Character,Integer> temp = itr.next();
            itr.remove();
            System.out.println(temp.getKey() + " " + temp.getValue());
        }
    }
}
