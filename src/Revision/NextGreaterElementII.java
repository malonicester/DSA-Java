package Revision;

import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {

    }

    static int[] nextGreaterII(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            stack.push(arr[i]);
        }
        for (int i = arr.length - 1; i >= 0; i--){
            if(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}
