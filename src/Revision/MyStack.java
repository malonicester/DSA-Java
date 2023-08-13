package Revision;

import java.util.*;

public class MyStack {
    private LinkedList<Integer> stack;
    int size = 0;

    public MyStack() {
        this.stack = new LinkedList<>();
        this.size = -1;
    }
    public int push(int e){
        size++;
        stack.add(e);
        return e;
    }
    public int pop(){
        int ret = stack.get(size);
        size--;
        return ret;
    }
    public int peek(){
        return stack.get(size);
    }
    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
       String s = "my name is ashish";
       String[]newarr = s.split(" ");
       String[]arr = {"my","name","is"};
       Map<String,Integer> map = new HashMap<>();
       for(String a:newarr){
           map.put(a,map.getOrDefault(a,0)+1);
       }
       Integer.parseInt("1000000");
       for(String a : arr){
           if(map.containsKey(a)){
               System.out.println(a);
           }
       }
    }
}
