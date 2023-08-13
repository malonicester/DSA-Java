package Java8;

/*
 * Easy to implement than other pattern
 * Just to use an additional inner static class
 * Can be refracted into
 * Number of lines of code can be huge
 */
public class Employee {
    private String firstName;
    private String lastName;

    private String fatherName;
    private String motherName;
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public Employee (EmployeeBuilder employeeBuilder) {
        this.firstName = employeeBuilder.firstName;
        this.lastName = employeeBuilder.lastName;
        this.fatherName = employeeBuilder.fatherName;
        this.motherName = employeeBuilder.motherName;
        this.address = employeeBuilder.address;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    static class EmployeeBuilder {
        private String firstName;
        private String lastName;

        private String fatherName;
        private String motherName;
        private String address;



        public EmployeeBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder fatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public EmployeeBuilder motherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public EmployeeBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
