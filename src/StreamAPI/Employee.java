package StreamAPI;

public class Employee {
    private String name;
    private Integer salary;
    private String grade;

    public Employee(String name, Integer salary, String grade) {
        super();
        this.name = name;
        this.salary = salary;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "name=" + name + ", salary=" + salary + ", grade=" + grade + "\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}