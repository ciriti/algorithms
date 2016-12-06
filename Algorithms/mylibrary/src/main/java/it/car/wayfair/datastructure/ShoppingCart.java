package it.car.wayfair.datastructure;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by carmeloiriti, 13/10/16.
 */
public class ShoppingCart<T>{

    LinkedHashMap<Product<T>, Integer> dataStructure = new LinkedHashMap<>();

    /**
     *
     */
    final static class Product<T>{

        final T item;

        public Product(T item) {
            this.item = item;
        }

        @Override
        public int hashCode(){
            int hash = 1;
            hash = 31 * hash + item.hashCode();
            return hash;
        }

        @Override
        public boolean equals(Object o) {
            if(o == null || !(o instanceof Product)) return false;
            Product p = (Product)o;
            return p.item.equals(this.item);
        }

        @Override
        public String toString(){
            return item.toString();
        }
    }

    public void add(T item, int quantity){
        Product<T> p = new Product<>(item);
        if(!dataStructure.containsKey(p))
            dataStructure.put(p, 0);
        dataStructure.put(p, dataStructure.get(p) + quantity);
    }

    public void add(T item){
        add(item, 1);
    }

    public void remove(T item){
        dataStructure.remove(new Product<>(item));
    }

    public int get(T item){
        Product<T> p = new Product<>(item);
        if(!dataStructure.containsKey(p)) return 0;
        return dataStructure.get(p);
    }

    public String show(){
        Product<T> p;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Set<Product<T>> keys = dataStructure.keySet();
        Iterator<Product<T>> i = keys.iterator();
        if(i.hasNext()){
            p = i.next();
            sb.append("[" + p + ",  " + dataStructure.get(p)+ "]");
        }

        while(i.hasNext()){
            p = i.next();
            sb.append(", [" + p + ",  " + dataStructure.get(p)+ "]");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String args[]){

        ShoppingCart<String> cart = new ShoppingCart<>();
        cart.add("chair");
        cart.add("chair", 2);
        cart.add("table");
        cart.add("table", 4);
        cart.add("lamp");
        cart.remove("chair");
        System.out.println(cart.show());
    }

}
