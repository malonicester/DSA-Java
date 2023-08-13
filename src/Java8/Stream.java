package Java8;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream {

    public static List<Student> studentList = List.of(
            new Student(1,"Ashish","FW_22"),
            new Student(4,"Ramesh","FW_22"),
            new Student(5,"Manish","FW_23"),
            new Student(9,"Chandan","FW_23")
    );
    public  Integer method(String s){
        return s.length()*2;
    }



    public static void main(String[] args) {
//        Map<String, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy(student -> student.batch()));
//        System.out.println(collect);
        Queue<Student> queue = new PriorityQueue<>();
        queue.addAll(studentList);
        System.out.println(queue.peek());
//        queue.add(null);
        queue.remove();
        System.out.println(queue.peek());
        Stream s = new Stream();
        Function<String,Integer> fun = s::method;
        List<String> collect = studentList.stream().map(Student::name).sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        System.out.println(collect);
        Intr in = System.out::println;
        in.print(collect);
    }
}

record Student(int roll,String name,String batch) implements Comparable<Student>{
    public void print(){
        System.out.println(this.roll+" "+this.name);
    }

    @Override
    public int compareTo(Student o) {
        return o.roll() - this.roll();
    }
}

@FunctionalInterface
interface Intr {
    public void print(Object str);
}