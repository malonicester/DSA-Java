package Recursion;

public class OuterClass {
    int a = 10;
    class InnerClass{
        int b = 20;
    }

    public static void main(String[] args) {
        OuterClass obj = new OuterClass();
        OuterClass.InnerClass obj1 =  obj.new InnerClass();
        System.out.println(obj1.b);
    }
}
