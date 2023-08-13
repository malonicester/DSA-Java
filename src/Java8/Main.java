package Java8;

public class Main {
    public static void main(String[] args) {
        Employee.EmployeeBuilder employee = new Employee.EmployeeBuilder();
        employee.firstName("ashish").fatherName("shibaraman").motherName("kalyani").address("kalinga vihar");
        Employee employee1 = employee.build();
        System.out.println(employee1);
    }
}
