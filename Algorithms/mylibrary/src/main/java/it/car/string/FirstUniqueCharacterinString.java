package it.car.string;

import java.util.Arrays;

/**
 * Created by carmeloiriti, 02/09/16.
 */
public class FirstUniqueCharacterinString {

    public int firstUniqChar(String s) {
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

}
