package it.car.wayfair.datastructure;

import java.util.Stack;

/**
 * Created by ciriti on 22/09/16.
 */

public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */

    public boolean isValid(String s) {

        if(s.length() == 0) return true;

        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()){
            if(c == '{' || c == '(' || c == '['){
                stack.add(c);
            }else if(c == '}' || c == ')' || c == ']'){
                if(stack.isEmpty()) return false;
                char p = stack.pop();
                if(c == ')' && p != '(') return false;
                if(c == ']' && p != '[') return false;
                if(c == '}' && p != '{') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String args[]){
        System.out.println(new ValidParentheses().isValid("([]{})") == true?"SUCCESS":"ERROR");
        System.out.println(new ValidParentheses().isValid("{{[()[]{}]}}") == true?"SUCCESS":"ERROR");
        System.out.println(new ValidParentheses().isValid("{{[([]{}]}}") == false?"SUCCESS":"ERROR");
        System.out.println(new ValidParentheses().isValid("[") == false?"SUCCESS":"ERROR");
    }

}
