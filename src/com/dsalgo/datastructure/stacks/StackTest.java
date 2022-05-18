package com.dsalgo.datastructure.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StackTest {
    public static void main(String[] args) {
        stackOps();
        Arrays.stream(nextGreatestElement(new int[]{4, 7, 3, 4, 8, 1})).forEach(System.out::print);
        System.out.println(validParenthesis("[{]"));
    }

    private static void stackOps() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        stack.pop();
        stack.pop();
        stack.display();
        System.out.println(stack.peek());
    }

    private static int[] nextGreatestElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            }else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    private static boolean validParenthesis(String str){
        Stack<String> stack = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put("}","{");
        map.put(")","(");
        map.put("]","[");
        for(String s: str.split("")){
            if(!map.containsKey(s)) stack.push(s);
            else {
                if(!map.get(s).equals(stack.peek())){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return true;
    }
}
