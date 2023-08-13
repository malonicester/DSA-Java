package Revision;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConsecutiveBalls {
    public static void main(String[] args) {
        int[] arr = {3, 5, 5, 5, 5, 5, 3, 3};
        int[] ans = consecutiveBalls(arr);
        System.out.println(Arrays.toString(ans));
        try {
            Person person = new Person(1, "Ashish");
            ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("a.ser"));
            oo.writeObject(person);
            long s = 0;
            ObjectInput oi = new ObjectInputStream(new FileInputStream("a.ser"));
            try {
                Person person1 = (Person) oi.readObject();
                System.out.println(person1);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static int[] consecutiveBalls(int[] arr) {
        int[] ans = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (!st.isEmpty() && st.peek() == a) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            } else {
                map.put(a, 1);
            }
            st.push(a);
            while (!st.isEmpty() && map.containsKey(st.peek()) && map.get(st.peek()) == a) {
                st.pop();
            }
            ans[i] = st.size();
        }
        return ans;
    }
}

class Person implements Serializable {
    int i;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "i=" + i +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(int i, String name) {
        this.i = i;
        this.name = name;
    }
}
