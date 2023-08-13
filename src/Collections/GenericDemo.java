package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        List<? super Number> list = new ArrayList<>();
        list.add(5);
        list.add(4.5);
        list.add(34.6);
        System.out.println(list);
        List<? extends Number> ls1 = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<? super Person> list1 = new ArrayList<>();
        list1.add(new Amy());
        list1.add(new Person());
        List<Amy> list2 = new ArrayList<>();
        list2.add(new Amy());
        list2.add(new Amy());
        list2.add(new Amy());
        list2.add(new Amy());
        List<? extends Person> list3 = list2;
        List<Number> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
    }

}

class Angel {
}

class Person extends Angel {
}

class Amy extends Person {
}
