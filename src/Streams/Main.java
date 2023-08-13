package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee(23, "Ashish", "IT"),
                new Employee(24, "Manish", "Sales"),
                new Employee(25, "Chandan", "Sales"),
                new Employee(22, "Atal", "HR"),
                new Employee(21, "Ezaz", "HR")
        );
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        List<Employee> emp = list.stream().sorted(Comparator.comparing(Employee::getDept).reversed())
                .collect(Collectors.toList());
        System.out.println(emp);
        map.forEach((k, v) -> System.out.println(k + " " + v));

        int[] arr = {1, 2, 3, 4, 4, 5, 5};
        double ans = Arrays.stream(arr).average().getAsDouble();
        System.out.println(ans);

    }
}

class Employee {
    int age;
    String name;
    String dept;

    public Employee() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Employee(int age, String name, String dept) {
        this.age = age;
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}