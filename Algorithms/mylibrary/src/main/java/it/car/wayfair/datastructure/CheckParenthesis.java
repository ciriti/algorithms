package it.car.wayfair.datastructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by carmeloiriti, 18/10/16.
 */
public class CheckParenthesis {



    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert your expression:");
        String test  = scan.nextLine();

        scan.close();

        System.out.println(test + " " + validate(test.toLowerCase()));
    }

    private static boolean validate(String test) {

        Deque<Character> stack = new LinkedList<>();

        char[] arr = test.toCharArray();

        for(char c : arr){

            if(isOpenParenthesis(c)){/** if open p add in stack */
                stack.offer(c);
            }else if(isCloseParenthesis(c)){ /** if close p check match*/
                if(stack.isEmpty())
                    return false;
                if(!match(stack.pollLast(), c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static boolean isOpenParenthesis(char p){
        return p == '{'
                || p == '['
                || p == '('
                ;
    }

    public static boolean isCloseParenthesis(char p){
        return p == '}'
                || p == ']'
                || p == ')'
                ;
    }

    public static boolean match(char pOpen, char pClose){
        if(pOpen == '(' && pClose == ')')return true;
        if(pOpen == '{' && pClose == '}')return true;
        if(pOpen == '[' && pClose == ']')return true;
        return false;
    }

}
