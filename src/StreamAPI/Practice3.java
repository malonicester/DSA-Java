package StreamAPI;


import java.util.*;
import java.util.function.BiFunction;

public class Practice3 {
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<>();
        map.put("a", new Employee("emp1", 90000, "A"));
        map.put("v", new Employee("emp1", 86000, "B"));
        map.put("b", new Employee("emp1", 96000, "C"));
        map.put("d", new Employee("emp1", 34000, "A"));
        map.put("e", new Employee("emp1", 78000, "C"));
        map.put("t", new Employee("emp1", 40000, "D"));
        map.put("g", new Employee("emp1", 80000, "A"));
        map.put("w", new Employee("emp1", 70000, "A"));
        List<Map.Entry<String, Employee>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().getSalary() - e1.getValue().getSalary());
        System.out.println(list);
        Set<Map.Entry<String, Employee>> st = map.entrySet();
        Iterator<Map.Entry<String, Employee>> itr = st.iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Employee> temp = itr.next();
            System.out.println(temp.getKey() + " " + temp.getValue());
        }
//        BiFunction<String, Employee, Employee> biFUn = (s, e) -> e.setSalary(e.getSalary()+2000);
//        map.replaceAll(biFUn);
    }

}
