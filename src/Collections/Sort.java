package Collections;

import java.util.Comparator;

public class Sort implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1;
        } else if (o2 > o1) {
            return 1;
        }
        return 0;
    }

}
