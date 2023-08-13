package Revision;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class SequenceValidation {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        boolean ans = sequenceValidation(pushed, popped);
        char b = '1';
        System.out.println(b >= 'a' && b <= 'z');
        Set<Student> students = new LinkedHashSet<>();
        students.add(null);
        students.add(new Student(1));
    }

    static boolean sequenceValidation(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < pushed.length; i++) {
            st.push(pushed[i]);
            while (!st.isEmpty() && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}

class Student implements Comparable<Student> {
    int roll;

    public Student(int roll) {
        this.roll = roll;
    }

    @Override
    public int compareTo(Student o) {
        return this.roll - o.roll;
    }
}