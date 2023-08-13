package Collections;

import java.util.Objects;

public class Student {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo, name);
    }

    public static void main(String[] args) {
        Student st1 = new Student(13,"Ashish");
        Student st2 = new Student(13,"harish");
        System.out.println(st1.equals(st2));
        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());
    }
}
