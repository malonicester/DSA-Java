package DSA421;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReduceString {
    public static void main(String[] args) {
        String ans = reduce("aaabccddd");
        System.out.println(ans);
    }
    static String reduce(String str){
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!dq.isEmpty() && dq.peekLast()==ch){
                dq.pollLast();
            }else{
                dq.offerLast(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.poll());
        }
        return sb.toString();
    }
}
