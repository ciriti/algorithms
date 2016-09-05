package it.car.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ciriti on 04/09/16.
 */

public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine
     * if the input string is valid. The brackets must close in the correct order, "()" and "()[]{}"
     * are all valid but "(]" and "([)]" are not.
     * @param args
     */

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la tua espressione:");
        String line = scanner.nextLine();
        scanner.close();
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println("isValid? " + parentheses.isValid(line));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isOpenParentheses(c)){
                stack.add(c);
            }else if(isCloseParentheses(c)){
                if(stack.isEmpty()) return false;
                char openP = stack.pop();
                if(!isValid(openP, c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isOpenParentheses(char c){
        return c == '['
                || c == '('
                || c == '{'
                ;
    }

    public boolean isCloseParentheses(char c){
        return c == ']'
                || c == '}'
                || c == ')'
                ;
    }

    public boolean isValid(char a, char b){
        if(a == '['){
            return b == ']';
        }else if(a == '('){
            return b == ')';
        }else if(a == '{'){
            return b == '}';
        }
        return false;
    }

}
