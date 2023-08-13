package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Practice2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Ashish", 70000, "A"));
        list.add(new Employee("Hanumat", 80000, "B"));
        list.add(new Employee("Emp3", 85000, "C"));
        list.add(new Employee("Emp4", 60000, "A"));
        list.add(new Employee("Emp6", 50000, "A"));
        list.add(new Employee("Emp7", 45000, "B"));
        list.add(new Employee("Emp8", 72000, "C"));
        list.add(new Employee("Emp9", 79000, "A"));
        list.add(new Employee("Emp10", 85000, "A"));
        list.add(new Employee("Emp11", 45000, "B"));
        list.add(new Employee("Emp12", 80000, "C"));
        list.add(new Employee("Emp13", 20000, "A"));
        list.add(new Employee("Emp14", 90000, "B"));
        list.add(new Employee("Emp15", 50000, "C"));

        Employee emp = list.stream().collect(Collectors.maxBy((e1, e2) -> e1.getName().length() > e2.getName().length() ? 1 : -1)).get();
        System.out.println(emp );
        Employee emp1 = list.stream().max((e1, e2) -> e1.getName().length() > e2.getName().length() ? 1 : -1).get();

        Employee maxSalariedEmp = list.stream().max((e1, e2) -> emp.getSalary() > e2.getSalary() ? 1 : -1).get();
        System.out.println(maxSalariedEmp);
        System.out.println("==================================================================================");
        double ans = list.stream().filter(e -> e.getSalary() >= 7000).map(Employee::getSalary).collect(Collectors.averagingDouble(Double::valueOf));
        System.out.println(ans);
        List<Employee> empList = list.stream().filter(e -> e.getSalary() >= 70000).collect(Collectors.toList());
        System.out.println(empList);
        System.out.println("===============================================================");
        List<Employee> topFiveSalariedEmp = list.stream().sorted((e1, e2) -> e1.getSalary() > e2.getSalary() ? -1 : 1).limit(5).collect(Collectors.toList());
        System.out.println(topFiveSalariedEmp);

        BiFunction<String, Integer, Integer> biFun = (key, val) -> val + 2000;
        
    }
}
