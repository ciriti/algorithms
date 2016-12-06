package it.car.string;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by carmeloiriti, 02/09/16.
 */
public class FirstUniqueCharacterinString {

    public static int firstUniqChar(String s) {
        if(s.length() == 0) return -1;
        int[] chars = new int[256];
        Arrays.fill(chars, 0);
        for(int i = 0; i < s.length(); i++){
            chars[s.charAt(i)]++;
        }
        for(int i = 0; i < s.length(); i++){
            if(chars[s.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public static char firstUniqCharII(String s) {
        LinkedHashMap<Character, Integer> ll = new LinkedHashMap<>();

        for(char c : s.toCharArray()){
            if(ll.containsKey(c)){
                Integer i = ll.get(c);
                i++;
                ll.put(c, i);
            }else{
                ll.put(c, 1);
            }
        }

        for(char c : ll.keySet()){
            if(ll.get(c)==1)
                return c;
        }

        return '-';

    }

    public static void main(String args[]){

        String s1 = "abcdeaba";
        StringBuilder sb = new StringBuilder(s1);
        for(int i = 0; i < 100000; i ++){
            sb.append(i%2==0?'a':'b');
        }
        String s = sb.toString();

        long start = 0;
        System.out.print(firstUniqCharII(s) =='c'? "SUCCESS ":"ERROR ");
        System.out.println(System.currentTimeMillis() - start);
        start = 0;
        System.out.print(s.charAt(firstUniqChar(s)) =='c'? "SUCCESS ":"ERROR ");
        System.out.println(System.currentTimeMillis() - start);
    }

}
