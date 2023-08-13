package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
//        Covariant--> Only for reading data
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        list.add(5);
        List<? extends Number> ls = list;
        List<? super Number> ls2 = new ArrayList<>();
        ls2.add(78);
        ls2.add(89);
        copy(ls, ls2);Integer[] myInts = {1,2,3,4};
        Number[] myNumber = myInts;
        myNumber[0] = 1.225;
        System.out.println(myNumber);
        String s = "j";
    }

    private static void sum(List<? extends Number> list) {
        double ans = 0;
        for (Number num : list) {
            ans += num.doubleValue();
        }
        System.out.println(ans);
    }

    private static void sum2(List<? super Number> list) {
        Number ans = 0;
        for (Object num : list) {
//            ans += (Number)num;
        }
        System.out.println(ans);
    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for (Number number : source) {
            destiny.add(number);
        }
        System.out.println(destiny);
    }
}

