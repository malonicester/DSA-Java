package Regex;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex7 {
    public static void main(String[] args) {
        String name = "EKP";
        String s = name+"[0-9]{3}";
        Pattern pat = Pattern.compile(s);
        Matcher m = pat.matcher("EK001");
        System.out.println(m.matches());
        Map<String,A> map = new HashMap<>();
        map.put("ashish",new A(5));
        System.out.println(map.get("ashish"));
    }
}
class A{
    int i;
    A (int i ){
        this.i = i;
    }
}
