package it.car.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ciriti on 21/08/16.
 */

public class Anagram {

  public static void main(String arg[]) {

    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    scanner.close();
    List<String> list = makeAnagram(text);
    System.out.println("size: " + list.size());
    System.out.println(Arrays.asList(list));
  }

  private static List<String> makeAnagram(String text) {
    return new ArrayList<>(recursiveAnagram(text));
  }

  private static Set<String> recursiveAnagram(final String pAnagram) {
    Set<String> res = new HashSet<>();
    char c;
    String subString;
    for (int i = 0; i < pAnagram.length(); i++) {
      c = pAnagram.charAt(i);
      subString = pAnagram.substring(0, i) + pAnagram.substring(i + 1, pAnagram.length());
      for (int j = 0; j < subString.length(); j++) {
        res.add(subString.substring(0, j) + c + subString.substring(j, subString.length()));
      }
      res.add(subString + c);
    }
    return res;
  }
}
