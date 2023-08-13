package Collections;

import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Scholar> st = new TreeSet<>();
        st.add(new Scholar(45, "rancho"));
        st.add(new Scholar(32, "chatur"));
        st.add(new Scholar(30, "raju"));
        st.add(new Scholar(28, "farhan"));
        st.add(new Scholar(32, "virus"));
        st.add(new Scholar(45, "joy"));
        List<Scholar> list = new ArrayList<>(st);
        System.out.println(list);
        list.clear();
        System.out.println(list);
//        ListIterator<Scholar> li = list.listIterator();
//        int index = 0;
//        while(li.hasNext()){
//            if(li.hasPrevious() && li.previous().marks == li.next().marks){
//                System.out.println(index++ +" " + li.next().name);
//            }else{
//                System.out.println(index++ +" " + li.next().name);
//            }
//        }
    }
}
class Scholar implements Comparable<Scholar> {
    int marks;
    String name;

    public Scholar(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Scholar{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Scholar o) {
        if (this.marks > o.marks) {
            return -1;
        } else if (this.marks < o.marks) {
            return 1;
        }
        return this.name.compareTo(o.name);

    }
}
