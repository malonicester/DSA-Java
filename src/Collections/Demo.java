package Collections;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        Set<Integer> st = new TreeSet<>(new SortBy());
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        System.out.println(st);
    }

}
class SortBy implements Comparator<Integer>{
    @Override
    public int compare(Integer o1,Integer o2){
        if(o1>o2){
            return -1;
        }else{
            return 1;
        }
    }
}
