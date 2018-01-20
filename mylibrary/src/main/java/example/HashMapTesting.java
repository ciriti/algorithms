package example;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ciriti on 04/12/16.
 */

public class HashMapTesting {

    static final class Person{

        public final String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if(null == o || !(o instanceof Person)) return false;

            return ((Person)o).name.equals(this.name);
        }

        @Override
        public int hashCode() {
            return 10;
        }
    }

    public static void main(String args[]){
//        HashMap<Person, Person> map = new HashMap<>();
//        Person p = new Person("Carmelo");
//        Person p1 = new Person("Fabio");
//        map.put(p, p);
//        map.put(p1, p1);
//        System.out.println();

            System.out.println(indexFor(7, 4));

    }

    static int indexFor(int h, int length) {
        return h & (length-1);
    }

}
